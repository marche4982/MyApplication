package com.example.youyou.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

/**
 * Created by youyou on 2017/12/29.
 */

public class ListClickListener implements  View.OnClickListener {

    private MemoDB memodb;
    private List<MemoDB> object;
    private Activity activity;

    ListClickListener(Activity activity, MemoDB memodb){
        this.activity = activity;
        this.memodb = memodb;
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(activity, MemoActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("title", memodb.getTitle());
        bundle.putString("body", memodb.getBody());
        bundle.putInt("id", memodb.getId());
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 0);
    }
}
