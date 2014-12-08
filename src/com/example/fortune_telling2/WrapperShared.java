package com.example.fortune_telling2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class WrapperShared {
	Context context;
    
    SharedPreferences pref;
    final String FILE_NAME = "file_name";
     
    public static final String KEY_RESULT    = "result";
     
    public WrapperShared(Context context) {
        this.context = context;
        this.pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }
     
    //データの保存
    public void saveString(String key, String value) {
        Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }
     
    //データの取得
    public String getString(String key, String default_value) {
        return pref.getString(key, default_value);
    }
}
