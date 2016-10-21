package com.example.huanxintest.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.huanxintest.model.city;
import com.example.huanxintest.model.county;
import com.example.huanxintest.model.province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class weatherManager {

    private static final String DB_NAME = "weather.db";
    private static final int DB_VERSION = 1;

    private static weatherManager manager;
    private  SQLiteDatabase db;


    private weatherManager(Context content) {
          myDBOpenHelper helper= new myDBOpenHelper(content,DB_NAME,null,DB_VERSION);
          db=helper.getWritableDatabase();
    }

    public synchronized weatherManager getIntance(Context content){
        if(manager==null){
            manager=new weatherManager(content);
        }
        return  manager;
    }


    public  void saveProvince(province provi){

        if(provi!=null){
            ContentValues value=new ContentValues();
            value.put("province_name",provi.getProvince_name());
            value.put("province_code",provi.getProvince_code());

            db.insert("Province",null,null);
        }
    }
    public  void saveCity(city ciy){

        if(ciy!=null){
            ContentValues value=new ContentValues();
            value.put("city_name",ciy.getCity_name());
            value.put("city_code",ciy.getCity_code());
            value.put("province_id",ciy.getProvince_id());

            db.insert("City",null,null);
        }
    }
    public  void saveCounty(county couny){

        if(couny!=null){
            ContentValues value=new ContentValues();
            value.put("county_name",couny.getCounty_name());
            value.put("county_code",couny.getCounty_code());
            value.put("city_id",couny.getCity_id());

            db.insert("County",null,null);
        }
    }


    public  List<province> loadProvinc(){
        List<province> pro_datas=new ArrayList<>();
        Cursor cursor=db.query("Province",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            province pro=new province();
            pro.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pro.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
            pro.setProvince_code(cursor.getString(cursor.getColumnIndex("province_code")));
            pro_datas.add(pro);
        }
        cursor.close();
        return pro_datas;
    }
    public  province loadProvincById(int province_id){
        province pro=null;
        Cursor cursor=db.query("Province",null,"province_code=?",new String[]{province_id+""},null,null,null);
        while (cursor.moveToNext()){
            pro=new province();
            pro.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pro.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
            pro.setProvince_code(cursor.getString(cursor.getColumnIndex("province_code")));
        }
        cursor.close();
        return pro;
    }

    public  List<city> loadCityById(int province_id){
        List<city> city_datas=new ArrayList<>();
        Cursor cursor=db.query("City",null,"province_id=?",new String[]{String.valueOf(province_id)},null,null,null);
        while (cursor.moveToNext()){
            city pro=new city();
            pro.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pro.setCity_name(cursor.getString(cursor.getColumnIndex("county_name")));
            pro.setCity_code(cursor.getString(cursor.getColumnIndex("county_code")));
            city_datas.add(pro);
        }
        cursor.close();
        return city_datas;
    }

}
