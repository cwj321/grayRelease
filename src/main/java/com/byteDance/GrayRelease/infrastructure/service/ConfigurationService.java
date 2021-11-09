package com.byteDance.GrayRelease.infrastructure.service;

import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import com.byteDance.GrayRelease.infrastructure.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationService {
    /**
     * @author zb
     * 写入数据库的服务
     */

    @Autowired
    RuleRepository ruleRepository;

    public boolean insertRule(RuleDTO ruleDTO){
        ruleRepository.insertRule(ruleDTO.convertToDO());
        return true;
    }
}
