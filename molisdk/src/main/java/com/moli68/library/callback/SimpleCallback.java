package com.moli68.library.callback;

import com.moli68.library.beans.MoBaseResult;
import com.moli68.library.util.MobileInfoUtils;

import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

public abstract class SimpleCallback<T extends MoBaseResult> extends BaseCallback<T> implements CallbackInterface<T> {

    @Override
    public void onRequestBefore() {

    }

    @Override
    public void onFailure(Request request, Exception e) {
        onFailed(e,"接口调用失败：001");
    }




    @Override
    public void onSuccess(Response response, T t) {
        if (t!=null&&t.isIssucc()){
            onSucceed(t);
        }else {
            onFailed(null,"接口调用成功，后台返回数据失败：002");
        }

    }

    @Override
    public void onError(Response response, int errorCode, Exception e) {
        onFailed(e,"错误：003");
    }

}
