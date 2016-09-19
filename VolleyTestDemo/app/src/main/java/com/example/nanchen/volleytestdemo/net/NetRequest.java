package com.example.nanchen.volleytestdemo.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanchen
 * @fileName VolleyTestDemo
 * @packageName com.example.nanchen.volleytestdemo.net
 * @date 2016/09/19  08:38
 */
public class NetRequest extends StringRequest {

    private Priority priority;
    private Map<String, String> headers;
    private Map<String, String> params;

    /**
     * 初始化全局变量
     */
    private void init() {
        priority = Priority.NORMAL;
        headers = new HashMap<>();
        params = new HashMap<>();
    }

    public NetRequest(int method, String url, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        init();
    }

    public NetRequest(String url, Listener<String> listener, ErrorListener errorListener) {
        super(url, listener, errorListener);
        init();
    }

    /**
     * 设置优先级
     */
    public NetRequest setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    /**
     * 为请求添加头信息的方法
     */
    public NetRequest addRequstHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public NetRequest addParams(String key, String value) {
        this.params.put(key, value);
        return this;
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }


    /**
     * 发送请求
     */
    public void start() {
        VolleyUtil.start(this);
    }


    /**
     * 自定义一个静态类Bulider为网络请求穿残，这也是构造者模式
     */
    public static class Builder {
        private String url;
        private int method;
        private Callback callback;

        public Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setMethod(int method) {
            this.method = method;
            return this;
        }

        /**
         * 自定义一个build方法请求网络返回NetRequest(这一步非常关键)
         */
        public NetRequest build() {
            return new NetRequest(method, url,
                    new Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (callback != null){
                                callback.onSuccess(response);
                            }
                        }
                    },
                    new ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (callback != null){
                                callback.onError(error);
                            }
                        }
                    });
        }
    }


}
