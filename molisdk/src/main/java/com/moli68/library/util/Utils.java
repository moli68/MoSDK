package com.moli68.library.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class Utils {
        private static MessageDigest digest;

//    public static Map<String,String> stringMap = new HashMap<>();

    /**
     *        得到手机设备标识码
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getDevice(Context context){
        String device = "";
        Boolean getdevice = SpUtils.getInstance().getBoolean("getdevice", true);

        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED){
            if (getdevice) {

                device = tm.getDeviceId();

            }else {
                if (!SpUtils.getInstance().getString("getDevicekey").equals("") && SpUtils.getInstance().getString("getDevicekey") != null){

                    device = SpUtils.getInstance().getString("getDevicekey");

                }
            }
        }else {

            if (getdevice) {
                String yyyyMMdd = getDate("yyyyMMdd");
                String stringRandom = getStringRandom(128);
                String str = yyyyMMdd + stringRandom;
                str = str.replace("\n", "");//去除换行
                str = str.replace("\\s", "");//去除空格
                digest.update(str.getBytes());
                device = byte2hex(digest.digest());
                SpUtils.getInstance().putString("getDevicekey", device);
                SpUtils.getInstance().putBoolean("getdevice",false);
            }else {
                if (!SpUtils.getInstance().getString("getDevicekey").equals("") && SpUtils.getInstance().getString("getDevicekey") != null){
                    device = SpUtils.getInstance().getString("getDevicekey");
                }
            }

        }
        return device;
    }


    /**
     *       生成随机数字和字母
     * @param length        长度
     * @return
     */
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     *      得到年月日
     * @param type      格式
     * @return
     */
    public static String getDate(String type){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     *          判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if (str  == null || str.equals("") || str.equals("null")){
            return true;
        }
        return false;
    }

    /**
     *          判断字符串不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     *          数组转字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs;
    }

    /**
     *          判断当前网络是否可用
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context){
        boolean result = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null){
                NetworkInfo[] infos = connectivityManager.getAllNetworkInfo();
                if (infos != null){
                    for (int i = 0; i < infos.length; i++) {
                        if (infos[i].getState() == NetworkInfo.State.CONNECTED){
                            result = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *      判断当前网络状态是否是wifi
     * @param context
     * @return
     */
    public static boolean isWifi(Context context){
        boolean result = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null){
                NetworkInfo[] infos = connectivityManager.getAllNetworkInfo();
                if (infos != null){
                    for (int i = 0; i < infos.length; i++) {
                        if (infos[i].getType() == ConnectivityManager.TYPE_WIFI){
                            result = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *      判断是否是中国电信,联通,移动的正确电话号码
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        if (phone == null){
            return false;
        }
        	/*
	    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
	    联通：130、131、132、152、155、156、185、186
	    电信：133、153、180、189、（1349卫通）
	    */
        String telRegex = "[1][3578]\\d{9}";
        return phone.matches(telRegex);
    }


    /**
     * 判断是否已经获取 有权查看使用情况的应用程序 权限
     *
     * @param context
     * @return
     */
    public static boolean isSatAccessPermissionSet(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                PackageManager packageManager = context.getPackageManager();
                ApplicationInfo info = packageManager.getApplicationInfo(context.getPackageName(),0);
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
                appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,info.uid,info.packageName);
                return appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,info.uid,info.packageName) == AppOpsManager.MODE_ALLOWED;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return true;
        }
    }

    /**
     * 查看是存在查看使用情况的应用程序界面
     *
     * @return
     */
    public static boolean isNoOption(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            return list.size() > 0;
        }
        return false;
    }

    /**
     *  得到手机当前版本号
     * @return
     */
    public static String getVersion(Context context){
        String localVersion = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(),0);
            localVersion = String.valueOf(packageInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     *   比较本地版本和服务器版本大小
     * @param serverVersion     服务器版本号
     * @param localVersion      本地版本号
     * @return
     */
    public static boolean VersionCompare(String serverVersion, String localVersion){
        String[] server = serverVersion.split("[.]");
        String[] local = localVersion.split("[.]");

        for (int i = 0; i < server.length; i++) {
            if (i < local.length){
                int a = Integer.parseInt(server[i]);
                int b = Integer.parseInt(local[i]);
                if (a > b){
                    return true;
                }else if (a == b){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 获取字符的MD5码
     * @param pwd
     * @return
     */
    public  static String MD5(String pwd) {
        //用于加密的字符
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {   //  i = 0
                byte byte0 = md[i];  //95
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
                str[k++] = md5String[byte0 & 0xf];   //   F
            }

            //返回经过加密后的字符串
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }


}
