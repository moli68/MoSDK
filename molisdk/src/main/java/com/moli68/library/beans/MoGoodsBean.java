package com.moli68.library.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/9/28/0028.
 */

public class MoGoodsBean implements Serializable {
    /**
     * id : 1
     * val : 1
     * key : 会员1
     * ali : 0.01
     * wechat : 0.01
     * msg : 备注
     * price : 100
     * img_url : [{"url":"http://gtapp.ngrok.80xc.com:82/upload/vipbackgroundimg/2018-09-28/31db5b96-a609-40fb-bb2f-613ea832c27c.png","type":3},{"url":"http://gtapp.ngrok.80xc.com:82/upload/vipbackgroundimg/2018-09-28/31db5b96-a609-40fb-bb2f-613ea832c27c.png","type":4}]
     * pay : [1][2]
     */

    private int id;
    private String val;
    private String key;
    private double ali;
    private double wechat;
    private String msg;
    private int price;
    private String pay;
    private List<MoImgUrlBean> img_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getAli() {
        return ali;
    }

    public void setAli(double ali) {
        this.ali = ali;
    }

    public double getWechat() {
        return wechat;
    }

    public void setWechat(double wechat) {
        this.wechat = wechat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public List<MoImgUrlBean> getImg_url() {
        return img_url;
    }

    public void setImg_url(List<MoImgUrlBean> img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "MoGoodsBean{" +
                "id=" + id +
                ", val='" + val + '\'' +
                ", key='" + key + '\'' +
                ", ali=" + ali +
                ", wechat=" + wechat +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                ", pay='" + pay + '\'' +
                ", img_url=" + img_url +
                '}';
    }
}
