package com.example.youyou.myapplication;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by youyou on 2017/12/17.
 */

public class DbOperate {

    private Realm realm;

    DbOperate(Context context){
        Realm.init(context);
        RealmConfiguration rConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(rConfig);
        realm = Realm.getInstance(rConfig);

    }

    private MemoDB search(int id){
        return realm.where(MemoDB.class).equalTo("id", id).findFirst();
    }

    // カラムを追加する
    public void add(final MemoClass column){
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                int id = 0;
                Number max = realm.where(MemoDB.class).max("id");
                if( max != null ) {
                    id = max.intValue() + 1;
                }
                MemoDB db = realm.createObject(MemoDB.class, id);
                db.setTitle("aaa");
                db.setBody(column.getBody());
            }
        });
        return;
    }


    // カラムを更新
    public void update(MemoDB db, final MemoClass column){
        realm.beginTransaction();
        db.setBody(column.getBody());
        db.setTitle(column.getTitle());
        realm.commitTransaction();
    }

    public void save(MemoClass column){
        MemoDB db = search(column.getid());
        if( db == null ){
            add(column);
        }
        else{
            update(db, column);
        }
    }

    // カラムを削除
    public void delete(MemoClass column){
        MemoDB db = search(column.getid());
        if( db != null ){
            realm.beginTransaction();
            db.deleteFromRealm();
            realm.commitTransaction();
        }
    }

    // すべて取得
    public  RealmResults<MemoDB> getall(){
        RealmResults<MemoDB> results= realm.where(MemoDB.class).findAll();
        return results;
    }
}
