package com.example.huanxintest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/21.
 */
public class myDBOpenHelper  extends SQLiteOpenHelper{

    /***
     * 创建省表
     */

    private String province="create table Province(id integer primary key autoincrement,province_name text, province_code text )";
    /***
     * 创建市表
     */

    private String city="create table City(id integer primary key autoincrement,city_name text, city_code text,province_id integer )";
    /***
     * 创建县表
     */

    private String county="create table County(id integer primary key autoincrement,county_name text, county_code text,city_id integer )";

    public myDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(province);
        db.execSQL(city);
        db.execSQL(county);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
