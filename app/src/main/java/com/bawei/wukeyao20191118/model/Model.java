package com.bawei.wukeyao20191118.model;

import com.bawei.wukeyao20191118.contract.Contracts;
import com.bawei.wukeyao20191118.until.VolleyUntil;

import java.util.Map;

/**
 * 功能：Model类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：9:03
 */
public class Model implements Contracts.IModel {
    @Override
    public void getInfo(String url, final Contracts.myCallBack myCallBack) {
        VolleyUntil.getInstance().getInfo(url, new VolleyUntil.VolleyCallBack() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });


    }

    @Override
    public void postInfo(String url, final Map<String, String> map, final Contracts.myCallBack myCallBack) {
     VolleyUntil.getInstance().postInfo(url, map, new VolleyUntil.VolleyCallBack() {
         @Override
         public void onSuccess(String json) {
             myCallBack.onSuccess(json);
         }

         @Override
         public void onError(String error) {
            myCallBack.onError(error);
         }
     });
    }
}