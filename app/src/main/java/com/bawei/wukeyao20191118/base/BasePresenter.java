package com.bawei.wukeyao20191118.base;

import com.bawei.wukeyao20191118.contract.Contracts;

import java.lang.ref.WeakReference;

/**
 * 功能：BasePresenter类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：9:03
 */
public abstract class BasePresenter <V extends Contracts.IView> implements Contracts.Presenter {

    //虚引用
    WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    //定义一个model层的方法

    abstract protected  void initModel();


    public void onAttachView(V view){
        mWeak = new WeakReference<>(view);
    }


    public void onDeattchView(){
        if (mWeak!=null){
            mWeak.clear();
            mWeak=null;
        }
    }


    //获取view
    public V getView(){
       return mWeak.get();
    }
}
