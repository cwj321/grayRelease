package com.byteDance.GrayRelease.domain;

import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.Resp;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RuleService {


    @Autowired
    RuleMatchingManager ruleMatchingManager;
    @Autowired
    StatisticsService statisticsService;


    /**
     * 得到一条单一的rule并且构造resp返回
     * @param req
     * @return
     */
    public Resp getSingleRule(Req req) {
        RuleDTO rule = ruleMatchingManager.doGetRule(req);
        if (rule == null) {
            return Resp.build();
        }
        return Resp.build(rule);
    }

}
