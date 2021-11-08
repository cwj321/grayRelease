package com.byteDance.GrayRelease.infrastructure.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Resp {

    /**
     * 下载连接
     */
    String download_url;
    /**
     * 包的当前版本号
     */
    String update_version_code;
    /**
     * 包的md5
     */
    String md5;
    /**
     * 弹窗标题
     */
    String title;
    /**
     * 弹窗的更新文本
     */
    String update_tips;

    public void setDownload_url(String download_url){
        this.download_url = download_url;
    }

    public void setUpdate_version_code(String update_version_code){
        this.update_version_code = update_version_code;
    }

    public void setMd5(String md5){
        this.md5 = md5;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setUpdate_tips(String update_tips){
        this.update_tips = update_tips;
    }

    public static Resp build(RuleDO rule) {
        Resp resp = new Resp();
        resp.setDownload_url(rule.getDownload_url());
        resp.setUpdate_version_code(rule.getUpdate_version_code());
        resp.setMd5(rule.getMd5());
        resp.setTitle(rule.getTitle());
        resp.setUpdate_tips(rule.getUpdate_tips());
        return resp;
    }

    public static Resp build() {
        return new Resp();
    }

}

