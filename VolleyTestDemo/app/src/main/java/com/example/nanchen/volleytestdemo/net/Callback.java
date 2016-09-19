package com.example.nanchen.volleytestdemo.net;

import com.android.volley.VolleyError;

/**
 * @author nanchen
 * @fileName VolleyTestDemo
 * @packageName com.example.nanchen.volleytestdemo.net
 * @date 2016/09/19  08:56
 */
public interface Callback {

    /**
     * 当请求成功
     */
    void onSuccess(String response);

    /**
     * 当请求失败
     */
    void onError(VolleyError error);
}
