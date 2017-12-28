package com.example.youyou.myapplication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import android.content.Intent;

import java.util.List;

/**
 * Created by youyou on 2017/12/03.
 */

public class MyListAdapter extends ArrayAdapter<MemoClass>{

    private LayoutInflater inflater;
    MemoClass memo;
    public static Activity activity;

    public MyListAdapter(Context context, int resource, List<MemoClass> object){
        super(context, resource, object);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if( convertView == null ){
            convertView = inflater.inflate(R.layout.memoclass, null);
        }

        memo = new MemoClass();
        memo = (MemoClass)getItem(position);
        activity = (Activity)getContext();

        TextView textView = (TextView)convertView.findViewById(R.id.memoTitle);
        if( textView != null ){
            textView.setText(memo.getBody());

            textView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    Log.d("MotionEvent", ((Integer) motionEvent.getAction()).toString());

                    // リストビューの各要素をタッチした時の動き。
                    // ???
                    if( motionEvent.getAction() == MotionEvent.ACTION_DOWN ) {
                        Intent intent = new Intent(getContext(), MemoActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("title", memo.getTitle());
                        bundle.putString("body", memo.getBody());
                        bundle.putInt("id", memo.getid());
                        intent.putExtras(bundle);
                        activity.startActivity(intent);
                    }

                    return false;
                }
            });
        }

        return convertView;
    }

}
