package com.byteDance.GrayRelease.domain;

import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import com.byteDance.GrayRelease.infrastructure.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于匹配规则
 */
@Component
public class RuleMatchingManager {


    @Autowired
    RedisCache redisCache;

    @Autowired
    RuleRepository ruleRepository;


    /**
     * 对 req 匹配 返回一条rule
     * @param req
     * @return
     */
    public RuleDTO doGetRule(Req req) {
        List<RuleDTO> rules = ruleRepository.selectList(req);
        RuleDTO ans = rules.stream()
                .filter(rule -> versionCompare(req.getUpdate_version_code(), rule.getMin_update_version_code()) >= 0
                        && versionCompare(req.getUpdate_version_code(), rule.getMax_update_version_code()) <= 0)
                .filter(rule -> rule.getMax_os_api() >= req.getOs_api() &&
                rule.getMin_os_api() <= req.getOs_api())
                .filter(rule -> inWhiteList(req, rule)) //白名单匹配
                .filter(ruleDTO -> {
                    return ruleDTO.getEnv().equals("pro");
                }) // 判断是否是线上环境
                .sorted((r1, r2) -> versionCompare(r2.getUpdate_version_code(), r1.getUpdate_version_code()))
                .collect(Collectors.toList()).stream().findFirst().orElse(new RuleDTO());
        return ans;
    }


    /**
     * 是否在白名单内
     */
    public boolean inWhiteList(Req req,RuleDTO rule) {

        if(redisCache.isContains(rule,req)) {
            return true;
        }
        String rule_device_id_list = rule.getDevice_id_list();
        String req_device_id = req.getDevice_id();
        String[] rule_device_id_list_arr = rule_device_id_list.split(",");
        redisCache.add(rule_device_id_list_arr,rule); //将白名单加入到缓存set中,用于下一次的o(1)判断
        int len = rule_device_id_list_arr.length;
        for(int i = 0; i<len; ++i){
            if(req_device_id.equals(rule_device_id_list_arr[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * 安装包版本比较
     * 如果 s 的版本比 t 的版本大,返回 1
     * 相等则返回 0
     * 小于则返回 -1
     */
    public int versionCompare(String s,String t) {
        int slen = s.length();
        int tlen = t.length();
        //遍历
        int i = 0,j = 0;
        while (i < slen || j < tlen) {
            int num1 = 0,num2 = 0;
            while (i < slen && s.charAt(i) != '.') num1 = num1 * 10 + s.charAt(i++) - '0';
            while (j < tlen && t.charAt(j) != '.') num2 = num2 * 10 + t.charAt(j++) - '0';
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}

