package com.liantronics.ssp.demo;

import android.app.Application;

import liantronics.sspsdk.AdManager;


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        AdManager.init(this);//key

    }


}
