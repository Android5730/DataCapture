package com.itaem.datacapture.Utils;// 2023/9/14

import android.annotation.SuppressLint;
import android.content.Context;

// 作者:ITAEM 陈金城
@SuppressLint("StaticFieldLeak")
public class AppUtil {
    private volatile static AppUtil appUtil;
    private static Context context;
    public static AppUtil getInstance(Context context){
        if (appUtil==null){
            synchronized (AppUtil.class){
                if (appUtil==null){
                    appUtil = new AppUtil(context);
                }
            }
        }
        return appUtil;
    }

    public AppUtil(Context context) {
        AppUtil.context = context;
    }

    public static Context getContext() {
        return context;
    }
}
