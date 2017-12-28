package com.example.youyou.myapplication;

import android.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by youyou on 2017/12/11.
 */

public class MemoActivity extends Activity{

    private MemoClass memo = new MemoClass();
    private EditText editText;
    private Button button_save;
    private Button button_delete;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        memo = new MemoClass();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if( bundle != null ){
            memo.setid(bundle.getInt("id"));
            memo.setTitle(bundle.getString("title"));
            memo.setBody(bundle.getString("body"));
        }

        editText = (EditText)findViewById(R.id.editText);
        editText.setText(memo.getBody());

        button_save = (Button)findViewById(R.id.button_save);
        button_save.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                   memo.setBody(editText.getText().toString());
                    AddColumn(memo);
                    finish();
               }
               return false;
           }
       });

        button_delete = (Button)findViewById(R.id.button_delete);
        button_delete.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    MemoApplication.db.delete(memo);
                    finish();
                }
                return false;
            }
        });

        // 次回、テキストへのメモ書き込み、登録、更新を行う処理を描く
    }

    public void AddColumn(MemoClass memo){
        MemoApplication.db.add(memo);
    }


}
