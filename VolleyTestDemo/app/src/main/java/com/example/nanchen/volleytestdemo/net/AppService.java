package com.example.nanchen.volleytestdemo.net;

/**
 * @author nanchen
 * @fileName VolleyTestDemo
 * @packageName com.example.nanchen.volleytestdemo.net
 * @date 2016/09/19  10:10
 */
public class AppService {

    public static void registerUser(String username,String pwd,Callback callback){
        String url = Config.MOB_API_SERVICE_HOST+"user/rigister?key="
                +Config.MOB_APP_KEY+"&username="+username
                +"&password="+pwd+"&email=503233512@qq.com";
        VolleyUtil.get(url).setCallback(callback).build().start();
    }
}
