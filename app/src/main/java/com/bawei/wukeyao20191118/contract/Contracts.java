package com.bawei.wukeyao20191118.contract;

import java.util.Map;

/**
 * 功能：Contracts类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：9:00
 */
public interface Contracts {
    interface IModel{
        void getInfo(String url, myCallBack myCallBack);
        void postInfo(String url,Map<String,String>map,myCallBack myCallBack);
    }

    interface  IView{
        void onSuccess(String json);
        void onError(String error);
    }

    interface  Presenter{
        void onStartRequest(String url,Map<String,String>map);
    }
    //封装接口
    interface  myCallBack{
        void onSuccess(String json);
        void onError(String error);
    }
}
