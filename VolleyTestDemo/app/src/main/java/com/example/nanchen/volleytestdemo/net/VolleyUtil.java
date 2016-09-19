package com.example.nanchen.volleytestdemo.net;

import android.content.Context;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author nanchen
 * @fileName VolleyTestDemo
 * @packageName com.example.nanchen.volleytestdemo.net
 * @date 2016/09/19  08:52
 */
public class VolleyUtil {

    private static RequestQueue requestQueue;

    /**
     * 初始化请求队列
     */
    public static void init(Context mContext){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(mContext);
        }
    }

    /**
     * 设置get请求方法
     */
    public static NetRequest.Builder get(String url){
        return new NetRequest.Builder()
                .setMethod(Method.GET)
                .setUrl(url);
    }

    /**
     * 设置Post请求方法
     */
    public static NetRequest.Builder post(String url){
        return new NetRequest.Builder()
                .setMethod(Method.POST)
                .setUrl(url);
    }


    /**
     * 将请求添加到请求队列
     */
    public static void start(NetRequest netRequest){
        requestQueue.add(netRequest);
    }

    /**
     * 设置取消请求的方法,取消所有请求
     */
    public static void cancel(Object tag){
        requestQueue.cancelAll(tag);
    }

    /**
     * 自定义选择性的取消某个请求
     */
    public static void cancel(RequestQueue.RequestFilter filter){
        requestQueue.cancelAll(filter);
    }


}
