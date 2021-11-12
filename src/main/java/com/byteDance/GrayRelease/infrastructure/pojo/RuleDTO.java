package com.byteDance.GrayRelease.infrastructure.pojo;


import lombok.Data;

/**
 * 传给service层的实体类
 * @author cwj
 */
@Data
public class RuleDTO {
    /**
     * 对于每一条rule 的唯一标识
     */
    Integer aid;
    /**
     * 平台
     */
    String platform;
    /**
     * 下载连接
     */
    String download_url;
    /**
     * 包的当前版本号
     */
    String update_version_code;
    /**
     * 包的MD5
     */
    String md5;
    /**
     * 设备号白名单列表
     */
    String device_id_list;
    /**
     * 可升级的最大版本号
     */
    String max_update_version_code;
    /**
     * 可升级的最小版本号
     */
    String min_update_version_code;
    /**
     * 支持的最大操作系统版本
     */
    Integer max_os_api;
    /**
     * 支持的最小操作系统版本
     */
    Integer min_os_api;
    /**
     * cpu架构 32/64
     * 32位命中32位版本，64位命中64位版本
     */
    String cpu_arch;
    /**
     * 渠道号
     */
    String channel;
    /**
     * 弹窗标题
     */
    String title;
    /**
     * 弹窗的更新文本
     */
    String update_tips;

    /**
     * 环境：pro or dev 数据库默认为pro,只有配置中心更改后才改为pro
     */
    String env;

    public RuleDTO(Integer aid, String platform, String download_url,
                   String update_version_code, String md5, String device_id_list,
                   String max_update_version_code, String min_update_version_code,
                   Integer max_os_api, Integer min_os_api, String cpu_arch, String channel,
                   String title, String update_tips) {
        this.aid = aid;
        this.platform = platform;
        this.download_url = download_url;
        this.update_version_code = update_version_code;
        this.md5 = md5;
        this.device_id_list = device_id_list;
        this.max_update_version_code = max_update_version_code;
        this.min_update_version_code = min_update_version_code;
        this.max_os_api = max_os_api;
        this.min_os_api = min_os_api;
        this.cpu_arch = cpu_arch;
        this.channel = channel;
        this.title = title;
        this.update_tips = update_tips;
    }

    public RuleDTO() {
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }



    public int getId(){
        return aid;
    }

    public String getPlatform(){
        return platform;
    } 

    public String getDownload_url(){
        return download_url;
    }

    public String getMd5(){
        return md5;
    }

    public int getMax_os_api(){
        return max_os_api;
    }

    public int getMin_os_api(){
        return min_os_api;
    }

    public String getUpdate_version_code(){
        return update_version_code;
    }

    public String getMax_update_version_code(){
        return max_update_version_code;
    }

    public String getMin_update_version_code(){
        return min_update_version_code;
    }

    public String getCpu_arch(){
        return cpu_arch;
    }

    public String getChannel(){
        return channel;
    }

    public String getTitle(){
        return title;
    }

    public String getUpdate_tips(){
        return update_tips;
    }

    public String getDevice_id_list(){
        return device_id_list;
    }


    public RuleDO convertToDO() {
        RuleDO ruleDO = new RuleDO();
        ruleDO.setAid(this.aid);
        ruleDO.setPlatform(this.platform);
        ruleDO.setDownload_url(this.download_url);
        ruleDO.setUpdate_version_code(this.update_version_code);
        ruleDO.setMd5(this.md5);
        ruleDO.setDevice_id_list(this.device_id_list);
        ruleDO.setMax_update_version_code(this.max_update_version_code);
        ruleDO.setMin_update_version_code(this.min_update_version_code);
        ruleDO.setMax_os_api(this.max_os_api);
        ruleDO.setMin_os_api(this.min_os_api);
        ruleDO.setCpu_arch(this.cpu_arch);
        ruleDO.setChannel(this.channel);
        ruleDO.setTitle(this.title);
        ruleDO.setUpdate_tips(this.update_tips);
        ruleDO.setEnv(this.env);
        return ruleDO;
    }
}
