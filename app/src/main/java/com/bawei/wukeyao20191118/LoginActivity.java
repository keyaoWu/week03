package com.bawei.wukeyao20191118;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.wukeyao20191118.base.BaseActivity;
import com.bawei.wukeyao20191118.base.BasePresenter;
import com.bawei.wukeyao20191118.bean.Bean;
import com.bawei.wukeyao20191118.contrats.Contrats;
import com.bawei.wukeyao20191118.glide.GlideHolder;
import com.bawei.wukeyao20191118.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {


    private ImageView imageView;

    @Override
    protected void startCoding() {
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        String pwd = intent.getStringExtra("pwd");
        Map map = new HashMap();
        map.put("phone",phone);
        map.put("pwd",pwd);
        mPresenter.onStartRequest(Contrats.login,map);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        imageView = findViewById(R.id.image);
    }

    @Override
    protected int providerLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(String json) {
        Toast.makeText(this, ""+json, Toast.LENGTH_SHORT).show();
        Bean.ResultBean result = new Gson().fromJson(json, Bean.class).getResult();
        GlideHolder.ImageHolder(result.getHeadPic(),imageView);
    }

    @Override
    public void onError(String error) {

    }
}
