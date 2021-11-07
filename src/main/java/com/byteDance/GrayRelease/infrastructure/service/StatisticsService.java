package com.byteDance.GrayRelease.infrastructure.service;

import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDO;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 用于数据统计
 */
@Service
public class StatisticsService {

    Map<String,Integer> versionCnt = new ConcurrentHashMap<>(); //版本安装率

    /**
     * 对于数据进行统计
     * @param rule
     * @param req
     */
    public void statistics(RuleDO rule, Req req) {
        versionCnt.put(rule.getUpdate_version_code(),versionCnt.getOrDefault(rule.getUpdate_version_code(),0) + 1);
    }
}
