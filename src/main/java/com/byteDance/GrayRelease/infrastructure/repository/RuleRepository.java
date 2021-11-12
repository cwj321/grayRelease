package com.byteDance.GrayRelease.infrastructure.repository;


import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.mapper.RuleMapper;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDO;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * rule操作mapper
 * @author 陈文杰
 */
@Component
public class RuleRepository {

    @Autowired
    RuleMapper ruleMapper;

    /**
     * 优化: 建立复合索引加速匹配
     * 根据req请求数据库返回半匹配的数据 交给service继续匹配
     * 已经匹配platform,cpu_arch,channel,aid
     * @author cwj
     */
    public List<RuleDTO> selectList(Req req) {
        List<RuleDO> ruleDOs = ruleMapper.selectList(req);
        List<RuleDTO> ruleDTOs = ruleDOs.stream().map(this::transfer).collect(Collectors.toList());
        return ruleDTOs;
    }

    /**
     * 往数据库插入规则
     * @auther cwj
     */
    public void insertRule(RuleDO ruleDO) {
        ruleMapper.insertRule(ruleDO);
    }

    public void updateEnv(Long id,String env) {
        ruleMapper.updateEnv(id,env);
    }


    private RuleDTO transfer(RuleDO ruleDO) {
        RuleDTO ruleDTO = new RuleDTO();
        ruleDTO.setAid(ruleDO.getAid());
        ruleDTO.setPlatform(ruleDO.getPlatform());
        ruleDTO.setDownload_url(ruleDO.getDownload_url());
        ruleDTO.setUpdate_version_code(ruleDO.getUpdate_version_code());
        ruleDTO.setMax_update_version_code(ruleDO.getMax_update_version_code());
        ruleDTO.setMin_update_version_code(ruleDO.getMin_update_version_code());
        ruleDTO.setMd5(ruleDO.getMd5());
        ruleDTO.setDevice_id_list(ruleDO.getDevice_id_list());
        ruleDTO.setMax_os_api(ruleDO.getMax_os_api());
        ruleDTO.setMin_os_api(ruleDO.getMin_os_api());
        ruleDTO.setCpu_arch(ruleDO.getCpu_arch());
        ruleDTO.setChannel(ruleDO.getChannel());
        ruleDTO.setTitle(ruleDO.getTitle());
        ruleDTO.setUpdate_tips(ruleDO.getUpdate_tips());
        ruleDTO.setEnv(ruleDO.getEnv());
        return ruleDTO;
    }
}
