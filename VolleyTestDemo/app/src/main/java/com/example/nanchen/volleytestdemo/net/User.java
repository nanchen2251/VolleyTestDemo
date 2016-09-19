package com.example.nanchen.volleytestdemo.net;

/**
 * @author nanchen
 * @fileName VolleyTestDemo
 * @packageName com.example.nanchen.volleytestdemo.net
 * @date 2016/09/19  10:12
 */
public class User {
    private String retCode;
    private String msg;
    private String uid;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "retCode='" + retCode + '\'' +
                ", msg='" + msg + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
