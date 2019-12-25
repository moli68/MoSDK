package com.zeoy.geesdk;

import android.app.Application;

import com.moli68.library.initialization.MoliSDK;

/**
 * Created by zeoy92 on 2019/4/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MoliSDK.start(getApplicationContext()/*,"http://abcd.moli68.com/app/"*/);
        //MatisseUtil.initEngine(new MatisseUtilEngine());
    }
}
