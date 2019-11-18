package com.bawei.wukeyao20191118;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wukeyao20191118.base.BaseActivity;
import com.bawei.wukeyao20191118.base.BasePresenter;
import com.bawei.wukeyao20191118.contrats.Contrats;
import com.bawei.wukeyao20191118.presenter.Presenter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {


    private EditText phone;
    private EditText pwd;
    private Button zhuce;
    private Button login;
    private String regis_phone;
    private String regis_pwd;

    @Override
    protected void startCoding() {
     zhuce.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(MainActivity.this, RegisActivity.class);
             startActivityForResult(intent,100);
         }
     });
     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String login_phone = phone.getText().toString().trim();
             String login_pwd = pwd.getText().toString().trim();
             if (login_phone.isEmpty()){
                 Toast.makeText(MainActivity.this, "手机号为空", Toast.LENGTH_SHORT).show();
                 return;
             }else if (login_pwd.isEmpty()){
                 Toast.makeText(MainActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                 return;
             }else if(login_phone.equals(regis_phone) &&login_pwd.equals(regis_pwd)){

                 Map map = new HashMap();
                 map.put("phone",login_phone);
                 map.put("pwd",login_pwd);
                 Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                 intent.putExtra("phone",login_phone);
                 intent.putExtra("pwd",login_pwd);
                 startActivity(intent);
                 mPresenter.onStartRequest(Contrats.login,map);

             }
         }
     });
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
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        zhuce = findViewById(R.id.zhuce);
        login = findViewById(R.id.login);
    }

    @Override
    protected int providerLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        Toast.makeText(this, ""+json, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        regis_phone = data.getStringExtra("phone");
        regis_pwd = data.getStringExtra("pwd");
    }
}
