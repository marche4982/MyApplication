package com.example.youyou.myapplication;
import java.util.Date;

public class MemoClass {

    private  int      id;
    private  String   title;
    private  String   body;


    MemoClass(){
        this.title = "";
        this.body = "";
        this.id = -1;
    }

    public void setTitle(String title){
        this.title = title;
        return;
    }

    public String getTitle(){
        return this.title;
    }

    public void setBody(String body){
        this.body = body;
        return;
    }

    public String getBody(){
        return this.body;
    }

    public void setid(int id){
        this.id = id;
        return;
    }

    public int getid(){
        return this.id;
    }

};
