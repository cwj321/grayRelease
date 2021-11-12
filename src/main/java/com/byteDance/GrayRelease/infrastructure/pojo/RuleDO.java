package com.byteDance.GrayRelease.infrastructure.pojo;


import lombok.Getter;
import lombok.Setter;

/**
 * 数据库DO对象
 * @author cwj
 */
@Getter
@Setter
public class RuleDO {

    /**
     * 数据库主键
     */
    Long id;
    /**
     * app 的唯一标识
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
     * 环境: 开发or生产
     */
    String env;
    public int getAid(){
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
}
