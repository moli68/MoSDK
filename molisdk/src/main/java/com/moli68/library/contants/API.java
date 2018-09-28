package com.moli68.library.contants;

public interface API {

    /**
     * 通用接口
     */
      public static String COMMON_URL = "http://ap.moli68.com/app/";//正式接口
     //public static String COMMON_URL = "http://gtapp.ngrok.80xc.com:82/app/";//测试接口

    /**
     * 设备注册
     */
    public static String REGIST_DEVICE = "reg_device";

    /**
     *  更新数据
     */
    public static String UPDATE = "info_sync";

    /**
     * 新版检测
     */
    public static String GETNEW = "version_update";

    /**
     *意见反馈
     */
    public static String FEEDBACK = "feedback";

    /**
     * 老订单接口(支付宝，微信)
     */
    public static String ORDER_ONE = "order.one";


    /**
     * 新的支付接口，包括微信和支付宝
     */
    public static String ORDER_OD = "order.od";


}
