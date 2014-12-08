package com.example.fortune_telling2;

import java.util.Random;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("CommitPrefEdits") public class SubActivity extends Activity {
	public static String resultStr;
	public int[] mSound = new int[3];
	public char i;
	
	//サウンドクラス
		public class SePlayer {
			public SoundPool mSoundPool; 
			public int se[];// 読み込んだ効果音
			public SePlayer(Context context)
			{
				// new SoundPool(読み込むファイル数,読み込む種類,読み込む質)
				this.mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		 
				// load(コンテキスト,読み込むリソースID,音の優先度)
				mSound[0] = mSoundPool.load(context, R.raw.daikiti, 1);
				mSound[1] = mSoundPool.load(context, R.raw.ban1, 1);
				mSound[2] = mSoundPool.load(context, R.raw.fate1, 1);
			}
		 
			public void playSe()
			{
				// play(再生するサウンドID,左のボリューム,右のボリューム,優先度,ループ回数(0はしない、-1は無限),再生レート)
				mSoundPool.play(mSound[i], 1.0f, 1.0f, 1, 0, 1.0f);
			}
		}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout2);
        //背景色を黒に
		rl.setBackgroundColor(Color.BLACK);
		
		//プレイヤーの初期化
        final SePlayer se= new SePlayer(this); 
		
		//占いランダム処理
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("大吉");
				resultStr = "大吉";
				i = 0;
				break;
				
			case 2:
				resultLabel.setText("吉");
				resultStr = "吉";
				i = 1;
				break;
				
			case 3:
				resultLabel.setText("中吉");
				resultStr = "中吉";
				i = 1;
				break;
				
			case 4:
				resultLabel.setText("小吉");
				resultStr = "小吉";
				i = 1;
				break;
				
			case 5:
				resultLabel.setText("凶");
				resultStr = "凶";
				i = 2;
				break;
		}
		//SEの再生
		se.playSe();
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
		Toast.makeText(SubActivity.this, "保存しました", Toast.LENGTH_SHORT).show();
	}
	
		
}
