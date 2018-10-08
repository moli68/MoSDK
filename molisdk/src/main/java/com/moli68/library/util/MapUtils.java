package com.moli68.library.util;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;


public class MapUtils {

    private static Context mContext;

    /**
     *          在Application里面初始化，就能全局调用
     * @param context
     */
    public static void init(Context context){
        if (mContext == null){
            mContext = context;
        }else {
            return;
        }
    }

    /**
     *      通用Map
     *      (无参的方法通用调取)
     * @return
     */
    public static Map<String,String> getCurrencyMap(){
        Map<String,String> map = new HashMap<>();
        map.put("app_key", CPResourceUtils.getString("appid"));
        map.put("app_sign",null);
        map.put("device_number",CPResourceUtils.getDevice());
        return map;
    }

    /**
     *      注册
     * @return
     */
    public static Map<String,String> getRegistMap(){
        Map<String,String> map = new HashMap<>();
        map.putAll(getCurrencyMap());
        map.put("mobile_brand", SystemUtils.getDeviceBrand());
        map.put("mobile_model",SystemUtils.getSystemModel());
        map.put("pix_width",SystemUtils.getWith(mContext)+"");
        map.put("pix_height",SystemUtils.getHeight(mContext)+"");
        map.put("version_vername",SystemUtils.getSystemVersion());
        map.put("version_number",SystemUtils.getSystemVersionCode());
        map.put("mobile_product",SystemUtils.getChannelInfo(mContext)+"");
        return map;
    }

    /**
     *      版本更新
     * @return
     */
    public static Map<String,String> getNewMap(){
        Map<String,String> map = new HashMap<>();
        map.putAll(getCurrencyMap());
        map.put("var_number",Utils.getVersion(mContext));
        return map;
    }

    /**
     *      意见反馈
     * @param content       意见内容
     * @param phone         联系方式
     * @return
     */
    public static Map<String,String> getFeedBack(String content,String phone,String photos){
        Map<String,String> map = new HashMap<>();
        map.putAll(getCurrencyMap());
        map.put("msg",content);
        map.put("qq",phone);
        map.put("photos",photos);
        return map;
    }

    /**
     *      订单详情
     * @param type          订单类型    1:支付    2:打赏
     * @param pid           商品ID
     * @param amount        打赏订单必填,支付可不填
     * @param pway          支付类型    1:微信    2:支付宝
     * @return
     */
    public static Map<String,String> getOrder(int type,int pid,float amount,int pway){
        Map<String,String> map = new HashMap<>();
        map.putAll(getCurrencyMap());
        map.put("order_type",String.valueOf(type));
        map.put("order_serivce_id",String.valueOf(pid));
        map.put("money",String.valueOf(amount));
        map.put("order_way",String.valueOf(pway));
        return map;
    }

    /**
     * 获取反馈的map   默认设置了
     * @return
     */
    public static Map<String, String> getFeedBackMap() {
        Map<String,String> map = new HashMap<>();
        map.putAll(getCurrencyMap());
        map.put("page","1");
        map.put("limit","110");
        return map;
    }
}
