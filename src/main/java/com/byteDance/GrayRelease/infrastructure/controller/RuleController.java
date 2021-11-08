package com.byteDance.GrayRelease.infrastructure.controller;

import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.Resp;
import com.byteDance.GrayRelease.infrastructure.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleController {

    /**
     * @author zb
     * 获取用户请求数据，调用ruleService，返回Resp
     * @return
     */


    @Autowired
    private RuleService ruleService;

    //测试用
    //http://localhost:8080/user?version=v1&device_platform=IOS&device_id=11223344556677aa&os_api=15&channel=pinguo&version_code=8.14&update_version_code=8.14.01&aid=1111&cpu_arch=32
    @RequestMapping("/user")
    public Resp postUserInfo(@RequestParam("version") String version, @RequestParam("device_platform") String device_platform,
                             @RequestParam("device_id") String device_id, @RequestParam("os_api") Integer os_api,
                             @RequestParam("channel") String channel, @RequestParam("version_code") String version_code,
                             @RequestParam("update_version_code") String update_version_code, @RequestParam("aid") Integer aid,
                             @RequestParam("cpu_arch") Integer cpu_arch) {
        Req req = new Req(version, device_platform, device_id, os_api, channel, version_code, update_version_code, aid, cpu_arch);

        /**
         * 默认返回的是json
         */
        Resp singleRule = ruleService.getSingleRule(req);
        return singleRule;
        /**
         * test:返回一个只有url的Resp类
         */
//        Resp testRule = Resp.build();
//        testRule.setDownload_url("https://dldir1.qq.com/weixin/android/weixin8016android2040_arm64.apk");
//        return testRule;
    }
}
