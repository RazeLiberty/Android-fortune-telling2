package com.example.fortune_telling2;

import java.util.Random;

import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends Activity {
	/** Called when the activity is first created. */
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		//占いランダム処理
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("大吉");
				break;
				
			case 2:
				resultLabel.setText("吉");
				break;
				
			case 3:
				resultLabel.setText("中吉");
				break;
				
			case 4:
				resultLabel.setText("小吉");
				break;
				
			case 5:
				resultLabel.setText("凶");
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
				//保存
				android.content.SharedPreferences sp = getSharedPreferences("FortuneResult", MODE_PRIVATE);
				sp.edit().putString(resultLabel).commit();
				sp.edit().putInt("integer", 100).commit();
			}
		});
		
	}
}