package com.gtdev5.geetolsdk.mylibrary.beans;


import java.io.Serializable;
import java.util.List;

/**
 * Created by cheng
 * PackageName APP_Lock
 * 2018/1/24 11:00
 *      更新数据类
 */

public class UpdateBean implements Serializable {
    private Vip vip;
    private Boolean issucc;
    private String msg;
    private String code;
    private List<Ads> ads;
    private List<Gds> gds;
    private List<Swt> swt;
    private Contract contract;
    private String hpurl;

    public UpdateBean(){
    }

    public Boolean getIssucc() {
        return issucc;
    }

    public void setIssucc(Boolean issucc) {
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

    public List<Ads> getAds() {
        return ads;
    }

    public void setAds(List<Ads> ads) {
        this.ads = ads;
    }

    public List<Gds> getGds() {
        return gds;
    }

    public void setGds(List<Gds> gds) {
        this.gds = gds;
    }

    public List<Swt> getSwt() {
        return swt;
    }

    public void setSwt(List<Swt> swt) {
        this.swt = swt;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getHpurl() {
        return hpurl;
    }

    public void setHpurl(String hpurl) {
        this.hpurl = hpurl;
    }

    public Vip getVip() {
        return vip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }
}
