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
}
