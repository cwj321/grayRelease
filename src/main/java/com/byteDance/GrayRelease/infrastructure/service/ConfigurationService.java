package com.byteDance.GrayRelease.infrastructure.service;

import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationService {
    /**
     * @author zb
     * 写入数据库的服务
     */

    public boolean insertRule(RuleDTO ruleDTO){
        return true;
    }
}
