package com.byteDance.GrayRelease.adaptor;


import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import com.byteDance.GrayRelease.domain.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {
    /**
     * @author zb
     * 配置规则，调用ConfigurationService中的方法，写入数据库
     */

    @Autowired
    private ConfigurationService configurationService;

    @PostMapping("/save")
    public boolean postMethod(@RequestParam("aid") Integer aid, @RequestParam("platform") String platform,
                              @RequestParam("download_url") String download_url,
                              @RequestParam("update_version_code") String update_version_code,
                              @RequestParam("md5") String md5, @RequestParam("device_id_list") String device_id_list,
                              @RequestParam("max_update_version_code") String max_update_version_code,
                              @RequestParam("min_update_version_code") String min_update_version_code,
                              @RequestParam("max_os_api") Integer max_os_api,
                              @RequestParam("min_os_api") Integer min_os_api,
                              @RequestParam("cpu_arch") String cpu_arch, @RequestParam("channel") String channel,
                              @RequestParam("title") String title, @RequestParam("update_tips") String update_tips) {

        RuleDTO ruleDTO = new RuleDTO(aid, platform, download_url, update_version_code, md5, device_id_list, max_update_version_code,
                min_update_version_code, max_os_api, min_os_api, cpu_arch, channel, title, update_tips);
        return configurationService.insertRule(ruleDTO);
    }
}
