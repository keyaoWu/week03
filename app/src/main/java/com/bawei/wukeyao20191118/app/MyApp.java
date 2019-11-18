package com.bawei.wukeyao20191118.app;

import android.app.Application;
import android.content.Context;

/**
 * 功能：MyApp类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：8:52
 */
public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
