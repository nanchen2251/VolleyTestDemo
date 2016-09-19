package com.example.nanchen.volleytestdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.nanchen.volleytestdemo.net.AppService;
import com.example.nanchen.volleytestdemo.net.Callback;
import com.example.nanchen.volleytestdemo.net.VolleyUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VolleyUtil.init(getApplicationContext());

        AppService.registerUser("15680802251", "123456", new Callback() {
            @Override
            public void onSuccess(String response) {
                Log.e(TAG, response);
                Toast.makeText(MainActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(VolleyError error) {
                Log.e(TAG, "注册失败!");
                Log.e(TAG, error.toString());
            }
        });
    }
}
