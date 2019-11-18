package com.bawei.wukeyao20191118;

import android.content.Intent;
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
import java.util.regex.Pattern;

public class RegisActivity extends BaseActivity {
    private EditText phone;
    private EditText pwd;
    private Button zhuce;
    private String regular = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    private String regis_phone;
    private String regis_pwd;

    @Override
    protected void startCoding() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis_phone = phone.getText().toString().trim();
                regis_pwd = pwd.getText().toString().trim();
                if (regis_phone.isEmpty()){
                    Toast.makeText(RegisActivity.this, "手机号为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (regis_pwd.isEmpty()){
                    Toast.makeText(RegisActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    isDemo();
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
    }

    @Override
    protected int providerLayoutId() {
        return R.layout.activity_regis;
    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onError(String error) {

    }

    public void isDemo() {
        boolean matches = Pattern.matches(regular,regis_phone);
        if (matches){
            Map map = new HashMap();
            map.put("phone",regis_phone);
            map.put("pwd",regis_pwd);
            Intent intent = new Intent();
            intent.putExtra("phone",regis_phone);
            intent.putExtra("pwd",regis_pwd);
            setResult(100,intent);
            finish();
            mPresenter.onStartRequest(Contrats.regis,map);

        }else {

            Toast.makeText(this, "格式错误", Toast.LENGTH_SHORT).show();
        }

    }
}
