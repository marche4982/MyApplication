package com.example.youyou.myapplication;

import android.app.Application;

/**
 * Created by youyou on 2017/12/21.
 */

public class MemoApplication extends Application {

    public static DbOperate db;

    @Override
    public void onCreate(){
        super.onCreate();

        db = new DbOperate(this);
    }
}
