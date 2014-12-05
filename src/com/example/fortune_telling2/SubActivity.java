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
		int n = r.nextInt(3) + 1;
		TextView resultLabel = (TextView) findViewById(R.id.fortuneResult);
		switch(n){
			case 1:
				resultLabel.setText("大吉");
				break;
				
			case 2:
				resultLabel.setText("吉");
				break;
				
			case 3:
				resultLabel.setText("凶");
				break;
		}
		//ボタン
		Button backButton = (Button)findViewById(R.id.goBack);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 次画面のアクティビティ終了
				finish();
			}
			});
	}
}