package com.example.fortune_telling2;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends Activity {
	public static final int MENU_SELECT_A = 0;	
	
	//サウンドクラス
	public class SePlayer {
		public SoundPool mSoundPool; 
		public int se;// 読み込んだ効果音
	 
		public SePlayer(Context context)
		{
			// new SoundPool(読み込むファイル数,読み込む種類,読み込む質)
			this.mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	 
			// load(コンテキスト,読み込むリソースID,音の優先度)
			this.se = mSoundPool.load(context, R.raw.aaa, 1);
		}
	 
		public void playSe()
		{
			// play(再生するサウンドID,左のボリューム,右のボリューム,優先度,ループ回数(0はしない、-1は無限),再生レート)
			mSoundPool.play(se, 1.0f, 1.0f, 1, 0, 1.0f);
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout);
        //背景色を黒に
		rl.setBackgroundColor(Color.BLACK);
        
        //プレイヤーの初期化
        final SePlayer se= new SePlayer(this); 
        
        //運勢ボタン
        Button fortuneBtn = (Button)findViewById(R.id.fortuneButton);
        fortuneBtn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		//SEの再生
        		se.playSe();
        		// インテントのインスタンス生成
        		Intent intent = new Intent(MainActivity.this, SubActivity.class);
        		// 次画面のアクティビティ起動
        		startActivity(intent);
        	}
        });
        
      //ボタン
        Button pastFortuneBtn = (Button)findViewById(R.id.pastFortuneButton);
        pastFortuneBtn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		//SEの再生
        		se.playSe();
        		// インテントのインスタンス生成
        		Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        		// 次画面のアクティビティ起動
        		startActivity(intent);
        	}
        });
    }
    
    //メニュー
    public boolean onCreateOptionsMenu(Menu menu){
    	 
        menu.add(0, MENU_SELECT_A, 0, "finish App");
     
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_SELECT_A:
            Log.d("Menu","Select Menu A");
            finish();
            return true;
        }
        return false;
    }
 /*
    @Override
    protected void onPause() {
        super.onPause();
        // リリース
        mSoundPool.release();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        // 予め音声データを読み込む
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        SoundId = SoundPool.load(getApplicationContext(), R.raw.aaa, 0);
    }
  */
    
}