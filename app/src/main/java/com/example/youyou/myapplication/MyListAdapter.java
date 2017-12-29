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

public class MyListAdapter extends ArrayAdapter<MemoDB>{

    private LayoutInflater inflater;
    public MemoDB memo;
    public static Activity activity;
    TextView textView;
    List<MemoDB> list;

    public MyListAdapter(Context context, int resource, List<MemoDB> object){
        super(context, resource, object);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        if( convertView == null ){
            convertView = inflater.inflate(R.layout.memoclass, null);
        }

        memo = new MemoDB();
        memo = (MemoDB)getItem(position);
        activity = (Activity)getContext();

        textView = (TextView)convertView.findViewById(R.id.memoTitle);
        if( textView != null ){
            textView.setText(memo.getBody());
            textView.setClickable(true);

            textView.setOnClickListener(new ListClickListener(activity, memo) {});
        }

        return convertView;
    }

}
