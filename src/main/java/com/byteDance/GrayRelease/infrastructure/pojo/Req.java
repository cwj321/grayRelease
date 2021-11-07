package com.byteDance.GrayRelease.infrastructure.pojo;

import lombok.Data;

/**
 * 客户端上报参数
 */
@Data
public class Req {

    /**
     * 请求api版本
     */
    String version;
    /**
     * 设备平台
     */
    String device_platform;
    /**
     * 设备id
     */
    String device_id;
    /**
     * 安卓的系统版本
     */
    Integer os_api;
    /**
     * 渠道
     */
    String channel;
    /**
     * 应用大版本 比如8.1.4
     */
    String version_code;
    /**
     * 应用小版本 比如8.1.4.01
     */
    String update_version_code;
    /**
     * app 的唯一标识
     */
    Integer aid;
    /**
     * 设备的cpu架构
     */
    Integer cpu_arch;

    public String getDevice_platform(){
        return device_platform;
    }

    public String getChannel(){
        return channel;
    }

    public int getCpu_arch(){
        return cpu_arch;
    }

    public String getUpdate_version_code(){
        return update_version_code;
    }

    public int getOs_api(){
        return os_api;
    }

    public String getDevice_id(){
        return device_id;
    }
}
