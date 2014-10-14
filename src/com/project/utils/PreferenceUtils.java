package com.project.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PreferenceUtils {  
    public static String getPrefString(Context context, String key,  
            final String defaultValue) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        return sharedPreferences.getString(key, defaultValue);  
    }  
  
    public static void setPrefString(Context context, final String key,  
            final String value) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        sharedPreferences.edit().putString(key, value).commit();  
    }  
  
    public static boolean getPrefBoolean(Context context, final String key,  
            final boolean defaultValue) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        return sharedPreferences.getBoolean(key, defaultValue);  
    }  
  
    public static boolean hasKey(Context context, final String key) {  
        return PreferenceManager.getDefaultSharedPreferences(context).contains(  
                key);  
    }  
  
    public static void setPrefBoolean(Context context, final String key,  
            final boolean value) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        sharedPreferences.edit().putBoolean(key, value).commit();  
    }  
  
    public static void setPrefInt(Context context, final String key,  
            final int value) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        sharedPreferences.edit().putInt(key, value).commit();  
    }  
  
    public static int getPrefInt(Context context, final String key,  
            final int defaultValue) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        return sharedPreferences.getInt(key, defaultValue);  
    }  
  
    public static void setPrefFloat(Context context, final String key,  
            final float value) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        sharedPreferences.edit().putFloat(key, value).commit();  
    }  
  
    public static float getPrefFloat(Context context, final String key,  
            final float defaultValue) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        return sharedPreferences.getFloat(key, defaultValue);  
    }  
  
    public static void setSettingLong(Context context, final String key,  
            final long value) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        sharedPreferences.edit().putLong(key, value).commit();  
    }  
  
    public static long getPrefLong(Context context, final String key,  
            final long defaultValue) {  
        final SharedPreferences sharedPreferences = PreferenceManager  
                .getDefaultSharedPreferences(context);  
        return sharedPreferences.getLong(key, defaultValue);  
    }  
  
    public static void clearPreference(Context context,  
            final SharedPreferences p) {  
        final Editor editor = p.edit();  
        editor.clear();  
        editor.commit();  
    }  
} 