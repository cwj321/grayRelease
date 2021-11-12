package com.byteDance.GrayRelease.infrastructure.config;

import com.byteDance.GrayRelease.infrastructure.repository.RuleRepository;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * apollo 配置监听器
 * @author 陈文杰
 */
@Component
public class ApolloListener {

    @Autowired
    RuleRepository ruleRepository;

    @Value("${ExcludeRules}")
    List<String> PLACE_HOlDER_VALUE;

    @ApolloConfigChangeListener("application")
    private void someChangeHandler(ConfigChangeEvent changeEvent) {
        for (String changedKey : changeEvent.changedKeys()) {

            ConfigChange configChange = changeEvent.getChange(changedKey);
            String oldValue = configChange.getOldValue();
            String newValue = configChange.getNewValue();

            Set<String> oldList = Arrays.stream(oldValue.split(",")).collect(Collectors.toSet());
            Set<String> newList = Arrays.stream(newValue.split(",")).collect(Collectors.toSet());

            for (String s : oldList) {
                if (!newList.contains(s)) {
                    refreshEnv(s,"pro");
                }
            }
            for (String s : newList) {
                if (!oldList.contains(s)) {
                    refreshEnv(s,"dev");
                }
            }

            System.out.println("【changedKey:"+changedKey+",oldValue="+oldValue+", newValue:"+newValue+"】");

            refreshEnv(changedKey,newValue);
        }
    }


    /**
     * 修改数据库中rule的env参数
     */
    private void refreshEnv(String changedValue,String env) {
        try {
            ruleRepository.updateEnv(Long.parseLong(changedValue),env);
        } catch (Exception ex) { //忽略
        }
    }

}
