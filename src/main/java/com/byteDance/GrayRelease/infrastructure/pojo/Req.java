package com.byteDance.GrayRelease.infrastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 客户端上报参数
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Req(){

    }
    
    public Req(String version, String device_platform, String device_id, Integer os_api, String channel, String version_code, String update_version_code, Integer aid, Integer cpu_arch){
        this.version = version;
        this.device_platform = device_platform;
        this.device_id = device_id;
        this.os_api = os_api;
        this.channel = channel;
        this.version_code = version_code;
        this.update_version_code = update_version_code;
        this.aid = aid;
        this.cpu_arch = cpu_arch;
    }

    public String getDevice_platform(){
        return device_platform;
    }

    public String getChannel(){
        return channel;
    }

    public Integer getCpu_arch(){
        return cpu_arch;
    }

    public String getUpdate_version_code(){
        return update_version_code;
    }

    public Integer getOs_api(){
        return os_api;
    }

    public String getDevice_id(){
        return device_id;
    }

    public void setAid(Integer aid){
        this.aid = aid;
    }

    public void setChannel(String channel){
        this.channel = channel;
    }

    public void setCpu_arch(Integer cpu_arch){
        this.cpu_arch = cpu_arch;
    }

    public void setDevice_platform(String device_platform){
        this.device_platform = device_platform;
    }
    
}
