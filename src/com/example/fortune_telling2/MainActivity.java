package com.example.fortune_telling2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button)findViewById(R.id.button01_id);
        btn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		// インテントのインスタンス生成
        		Intent intent = new Intent(MainActivity.this, SubActivity.class);
        		// 次画面のアクティビティ起動
        		startActivity(intent);
        	}
        });
    }
}