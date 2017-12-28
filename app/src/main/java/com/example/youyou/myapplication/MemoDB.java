package com.example.youyou.myapplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by youyou on 2017/12/14.
 */

public class MemoDB extends RealmObject {

    @PrimaryKey
    private int id; // idカラム

    private String title;
    private String body;

    // getter setter...
    public int getId(){ return this.id;}

    public String getTitle(){ return this.title;}

    public String getBody(){ return this.body;}

    public void setId(int id){ this.id = id;}

    public void setTitle(String title){ this.title = title; }

    public void setBody(String body){ this.body = body;}

}
