package com.byteDance.GrayRelease.infrastructure.service;

import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 用于匹配规则
 */
@Component
public class RuleMatchingManager implements InitializingBean {


    /**
     * 记录所有的rule
     */
    public List<RuleDO> rules = new ArrayList<>();

    /**
     * <ruleId,ruleEnv> 记录配置中心更改的rule的状态
     */
    public Map<String,String> changeRules = new ConcurrentHashMap<>();


    /**
     * 对 req 匹配 返回一条rule
     * @param req
     * @return
     */
    public RuleDO doGetRule(Req req) {
        RuleDO ans = rules.stream()
                .filter(rule -> versionCompare(req.getUpdate_version_code(), rule.getMin_update_version_code()) >= 0
                        && versionCompare(req.getUpdate_version_code(), rule.getMax_update_version_code()) <= 0)
                .filter(rule -> rule.getMax_os_api() >= req.getOs_api() &&
                rule.getMin_os_api() <= req.getOs_api())
                .filter(rule -> inWhiteList(req, rule)) //白名单匹配
                .filter(rule -> {
                    if (!changeRules.containsKey(rule.getAid())) {
                        return true;
                    }
                    return changeRules.get(rule.getAid()).equals("pro");
                }) // 判断是否是线上环境
                .sorted((r1, r2) -> versionCompare(r2.getUpdate_version_code(), r1.getUpdate_version_code()))
                .collect(Collectors.toList()).stream().findFirst().get();
        return ans;
    }


    /**
     * 是否在白名单内
     */
    public boolean inWhiteList(Req req,RuleDO rule) {
        String rule_device_id_list = rule.getDevice_id_list();
        String req_device_id = req.getDevice_id();
        String[] rule_device_id_list_arr = rule_device_id_list.split(",");
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

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO: 2021/10/30  向list中加入数据 并且设置所有的rule默认为线上环境
    }
}

