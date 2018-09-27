package com.moli68.library.initialization;

import android.content.Context;
import com.moli68.library.util.CPResourceUtils;
import com.moli68.library.util.MapUtils;
import com.moli68.library.util.SpUtils;
import com.moli68.library.util.ToastUtils;


public class MoliSDK {
    public static String TAG = "MoliSDK";

    private static Context mContext;

    public static void start(Context context){
        try {
            if (mContext == null){
                mContext = context;
            }
            SpUtils.getInstance().init(mContext);
            CPResourceUtils.init(mContext);
            ToastUtils.init(mContext);
            MapUtils.init(mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
