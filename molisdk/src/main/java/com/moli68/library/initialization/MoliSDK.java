package com.moli68.library.initialization;

import android.content.Context;

import com.bun.miitmdid.core.JLibrary;
import com.moli68.library.contants.API;
import com.moli68.library.contants.Contants;
import com.moli68.library.util.CPResourceUtils;
import com.moli68.library.util.MapUtils;
import com.moli68.library.util.SpUtils;
import com.moli68.library.util.ToastUtils;
import com.moli68.library.util.Utils;


public class MoliSDK {
    public static String TAG = "MoliSDK";

    private static Context mContext;

    public static void start(Context context,String commonUrl){
        try {
            if (mContext == null){
                mContext = context;
            }
            JLibrary.InitEntry(mContext);
            SpUtils.getInstance().init(mContext);
            CPResourceUtils.init(mContext);
            ToastUtils.init(mContext);
            MapUtils.init(mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean temp;
        if (Utils.isEmpty(commonUrl)){
            temp = false;
        }else {
            temp = true;
            SpUtils.getInstance().putString(Contants.COMMON_URL,commonUrl);
        }
        SpUtils.getInstance().putBoolean(Contants.HAS_DEFINE_COMMON_URL,temp);
    }

    public static void start(Context context){
        start(context,null);
    }

}
