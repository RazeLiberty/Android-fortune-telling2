package com.example.fortune_telling2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends Activity {
	public static final int MENU_SELECT_A = 0;	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout);
        //背景色を黒に
		rl.setBackgroundColor(Color.BLACK);
        
        
        
        //運勢ボタン
        Button fortuneBtn = (Button)findViewById(R.id.fortuneButton);
        fortuneBtn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
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
        		loadData();
        	}
        });
    }
    
 // 読み込み
 		private void loadData() {
 			SharedPreferences sp = getSharedPreferences("com.example.fortune_telling2", 0);
 			SubActivity.resultStr = sp.getString("SAVE_DATA", SubActivity.resultStr);
 		    Toast.makeText(MainActivity.this, SubActivity.resultStr, Toast.LENGTH_SHORT).show();
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