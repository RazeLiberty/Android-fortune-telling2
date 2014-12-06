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
	
	//�T�E���h�N���X
	public class SePlayer {
		private SoundPool soundPool; 
		private int se;// �ǂݍ��񂾌��ʉ�
	 
		public SePlayer(Context context)
		{
			// new SoundPool(�ǂݍ��ރt�@�C����,�ǂݍ��ގ��,�ǂݍ��ގ�)
			this.soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	 
			// load(�R���e�L�X�g,�ǂݍ��ރ��\�[�XID,���̗D��x)
			this.se = soundPool.load(context, R.raw.aaa, 1);
		}
	 
		public void playSe()
		{
			// play(�Đ�����T�E���hID,���̃{�����[��,�E�̃{�����[��,�D��x,���[�v��(0�͂��Ȃ��A-1�͖���),�Đ����[�g)
			soundPool.play(se, 1.0f, 1.0f, 1, 0, 1.0f);
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //�܂����C�A�E�g�i�����ł̓��j�A�j���擾���A�w�i�F��t����
        RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout);

        //�w�i�F���_�[�N�O���C�ɂ���Ȃ�A
        rl.setBackgroundColor(Color.BLACK);
        
        //�v���C���[�̏�����
        final SePlayer se= new SePlayer(this); 
        
        //�{�^��
        Button btn = (Button)findViewById(R.id.button01_id);
        btn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		//SE�̍Đ�
        		se.playSe();
        		// �C���e���g�̃C���X�^���X����
        		Intent intent = new Intent(MainActivity.this, SubActivity.class);
        		// ����ʂ̃A�N�e�B�r�e�B�N��
        		startActivity(intent);
        	}
        });
    }
    
    //���j���[
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
        // �����[�X
        mSoundPool.release();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        // �\�߉����f�[�^��ǂݍ���
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.aaa, 0);
    }
   */ 
    
}