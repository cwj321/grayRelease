package com.byteDance.GrayRelease.infrastructure.mapper;


import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDO;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import com.byteDance.GrayRelease.infrastructure.repository.RuleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    RuleRepository ruleRepository;

    @Test
    public void selectList() {
        Req req = new Req();
        req.setAid(2);
        req.setChannel("浏览器");
        req.setCpu_arch(64);
        req.setDevice_platform("ios");
        List<RuleDTO> res = ruleRepository.selectList(req);
        res.forEach(System.out::println);
    }

    @Test
    public void insertRule() {
        RuleDO ruleDO = new RuleDO();
        ruleDO.setAid(2);
        ruleDO.setPlatform("ios");
        ruleDO.setDownload_url("https://bing.com");
        ruleDO.setUpdate_version_code("10.0.1");
        ruleDO.setMd5("sa2w14s");
        ruleDO.setDevice_id_list("a,b,c,d,e");
        ruleDO.setMax_update_version_code("9.0.1");
        ruleDO.setMin_update_version_code("9.0.0");
        ruleDO.setMax_os_api(11);
        ruleDO.setMin_os_api(10);
        ruleDO.setCpu_arch("64");
        ruleDO.setChannel("浏览器");
        ruleDO.setTitle("更新提示");
        ruleDO.setUpdate_tips("tip2");
        ruleRepository.insertRule(ruleDO);
    }


}
