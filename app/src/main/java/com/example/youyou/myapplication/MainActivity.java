package com.example.youyou.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    public ListView memoList;
    public MyListAdapter myListAdapter;
    public Button createButton;
    public TextView memoText;
    public MemoClass memo ;
    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memolist);
        activity = this;
        initialize();
        // メモ一つのクラスをつｋるう　ｘｍｌもつくる
        // それをリストのクラスに突っ込む　更新するｋ4
    }

    void initialize(){

        memo = new MemoClass();
        memoList = (ListView)findViewById(R.id.memoList);
        List<MemoClass> list = new ArrayList<MemoClass>();

        myListAdapter = new MyListAdapter(this, 0, list);
        memoList.setAdapter(myListAdapter);
        createButton = (Button)findViewById(R.id.button);
        createButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if( motionEvent.getAction() == MotionEvent.ACTION_DOWN ) {
                    Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                    activity.startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        myListAdapter.clear();

        RealmResults<MemoDB> all = MemoApplication.db.getall();
        for(MemoDB i : all){
            MemoClass memo = new MemoClass();
            memo.setTitle(i.getTitle());
            memo.setBody(i.getBody());
            myListAdapter.add(memo);
        }
    }
}
