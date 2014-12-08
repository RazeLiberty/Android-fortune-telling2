package com.example.fortune_telling2;

import java.util.Random;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("CommitPrefEdits") public class SubActivity extends Activity {
	WrapperShared shared = new WrapperShared(this);
	public String resultStr;
	public static String load_data;	//データ読み出し
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout);
        //背景色を黒に
		rl.setBackgroundColor(Color.BLACK);
		
		//占いランダム処理
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("大吉");
				resultStr = "大吉";
				break;
				
			case 2:
				resultLabel.setText("吉");
				resultStr = "吉";
				break;
				
			case 3:
				resultLabel.setText("中吉");
				resultStr = "中吉";
				break;
				
			case 4:
				resultLabel.setText("小吉");
				resultStr = "小吉";
				break;
				
			case 5:
				resultLabel.setText("凶");
				resultStr = "凶";
				break;
		}
		//やり直しボタン
		Button backButton = (Button)findViewById(R.id.goBack);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 次画面のアクティビティ終了
				finish();
			}
		});

		//結果保存ボタン
		Button saveButton = (Button)findViewById(R.id.save_button);
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveData();
			}
		});
	}
	// 保存
	private void saveData() {
		SharedPreferences.Editor sp = getSharedPreferences("com.example.fortune_telling2", 0).edit();
		sp.putString("SAVE_DATA", resultStr);
	}
	
		
}
