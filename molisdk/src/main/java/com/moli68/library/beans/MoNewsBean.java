package com.moli68.library.beans;

import java.io.Serializable;

/**
 * 请求更新的bean
 * Created by Administrator on 2018/10/7/0007.
 */

public class MoNewsBean implements Serializable {

    /**
     * new_version : false
     * url_down :
     * ver_name : 0.0.0
     * ver_number : 0
     * update_log :
     * issucc : true
     * msg :
     * code :
     */

    private boolean new_version;
    private String url_down;
    private String ver_name;
    private int ver_number;
    private String update_log;
    private boolean issucc;
    private String msg;
    private String code;

    public boolean isNew_version() {
        return new_version;
    }

    public void setNew_version(boolean new_version) {
        this.new_version = new_version;
    }

    public String getUrl_down() {
        return url_down;
    }

    public void setUrl_down(String url_down) {
        this.url_down = url_down;
    }

    public String getVer_name() {
        return ver_name;
    }

    public void setVer_name(String ver_name) {
        this.ver_name = ver_name;
    }

    public int getVer_number() {
        return ver_number;
    }

    public void setVer_number(int ver_number) {
        this.ver_number = ver_number;
    }

    public String getUpdate_log() {
        return update_log;
    }

    public void setUpdate_log(String update_log) {
        this.update_log = update_log;
    }

    public boolean isIssucc() {
        return issucc;
    }

    public void setIssucc(boolean issucc) {
        this.issucc = issucc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MoNewsBean{" +
                "new_version=" + new_version +
                ", url_down='" + url_down + '\'' +
                ", ver_name='" + ver_name + '\'' +
                ", ver_number=" + ver_number +
                ", update_log='" + update_log + '\'' +
                ", issucc=" + issucc +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
