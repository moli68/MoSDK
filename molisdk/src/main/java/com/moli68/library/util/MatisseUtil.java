package com.moli68.library.util;

import android.app.Activity;

import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;


/**
 * 图片选取工具
 */
public class MatisseUtil {
    //权限
    public static String[] PICTURE_PERMISSION = {android.Manifest.permission.CAMERA,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE};

    /**
     * 选择指定数量的照片
     * @param num
     */
    public static void GetPhoto(Activity context, int num,int permission_code,int image_code){

        PermissionUtils.checkAndRequestMorePermissions(context, PICTURE_PERMISSION, permission_code, new PermissionUtils.PermissionRequestSuccessCallBack() {
            @Override
            public void onHasPermission() {
                Matisse.from(context)
                        .choose(MimeType.allOf())
                        /*.capture(true)
                        .captureStrategy(new CaptureStrategy(true, "com.gtdev5.wechatpersonutils.fileprovider"))*/
                        .countable(true)
                        .maxSelectable(num)
                        .spanCount(4)
                        .imageEngine(new GlideEngine()).forResult(image_code);
            }
        });
    }
}
