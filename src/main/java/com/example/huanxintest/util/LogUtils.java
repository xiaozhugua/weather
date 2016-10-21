package com.example.huanxintest.util;

import android.util.Log;

/**
 * Created by Administrator on 2016/10/21.
 */
public class LogUtils {

    private static boolean isDebug=true;

    public static  void v(String tag,String message){
     if(isDebug){
         Log.v(tag,message);
     }
 }
}
