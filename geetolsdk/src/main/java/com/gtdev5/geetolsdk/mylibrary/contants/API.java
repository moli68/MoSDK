package com.gtdev5.geetolsdk.mylibrary.contants;

/**
 * Created by cheng
 * PackageName ModelTest
 * 2018/1/22 13:47
 *         接口管理类
 */

public interface API {

    /**
     * 通用接口
     */
      public static String COMMON_URL = "http://app.wm002.cn/app/";//正式接口
     //public static String COMMON_URL = "http://gtapp.ngrok.80xc.com:82/app/";//测试接口

    /**
     * 设备注册
     */
    public static String REGIST_DEVICE = "reg";

    /**
     *  更新数据
     */
    public static String UPDATE = "update";

    /**
     * 新版检测
     */
    public static String GETNEW = "getnew";

    /**
     *意见反馈
     */
    public static String FEEDBACK = "feedback";

    /**
     * 订单接口(支付宝，微信)
     */
    public static String ORDER_ONE = "order.one";


    /**
     * 添加服务单
     */
    public static String ADD_SERVICE = "sup.add_service";

    /**
     * 获取服务单
     */
    public static String GET_SERVICE = "sup.get_service";

    /**
     * 获取服务单详情
     */
    public static String GET_SERVICE_DETAILS = "sup.get_service_details";

    /**
     * 添加服务单回复
     */
    public static String ADD_REPLEY = "sup.add_reply";

    /**
     * 结束服务单
     */
    public static String END_SERVICE = "sup.end_service";




}
