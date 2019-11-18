package com.bawei.wukeyao20191118.presenter;

import com.bawei.wukeyao20191118.base.BasePresenter;
import com.bawei.wukeyao20191118.contract.Contracts;
import com.bawei.wukeyao20191118.model.Model;

import java.util.Map;

/**
 * 功能：Presenter类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：9:03
 */
public class Presenter extends BasePresenter {
    private Contracts.IModel model;
    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void onStartRequest(String url, Map<String, String> map) {
       model.postInfo(url, map, new Contracts.myCallBack() {
           @Override
           public void onSuccess(String json) {
               getView().onSuccess(json);
           }

           @Override
           public void onError(String error) {
             getView().onError(error);
           }
       });
    }
}
