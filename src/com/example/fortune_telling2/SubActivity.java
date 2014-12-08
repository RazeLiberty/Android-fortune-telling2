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
	
	//�T�E���h�N���X
		public class SePlayer {
			public SoundPool mSoundPool; 
			public int se[];// �ǂݍ��񂾌��ʉ�
			public SePlayer(Context context)
			{
				// new SoundPool(�ǂݍ��ރt�@�C����,�ǂݍ��ގ��,�ǂݍ��ގ�)
				this.mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		 
				// load(�R���e�L�X�g,�ǂݍ��ރ��\�[�XID,���̗D��x)
				mSound[0] = mSoundPool.load(context, R.raw.daikiti, 1);
				mSound[1] = mSoundPool.load(context, R.raw.ban1, 1);
				mSound[2] = mSoundPool.load(context, R.raw.fate1, 1);
			}
		 
			public void playSe()
			{
				// play(�Đ�����T�E���hID,���̃{�����[��,�E�̃{�����[��,�D��x,���[�v��(0�͂��Ȃ��A-1�͖���),�Đ����[�g)
				mSoundPool.play(mSound[i], 1.0f, 1.0f, 1, 0, 1.0f);
			}
		}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout2);
        //�w�i�F������
		rl.setBackgroundColor(Color.BLACK);
		
		//�v���C���[�̏�����
        final SePlayer se= new SePlayer(this); 
		
		//�肢�����_������
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("��g");
				resultStr = "��g";
				i = 0;
				break;
				
			case 2:
				resultLabel.setText("�g");
				resultStr = "�g";
				i = 1;
				break;
				
			case 3:
				resultLabel.setText("���g");
				resultStr = "���g";
				i = 1;
				break;
				
			case 4:
				resultLabel.setText("���g");
				resultStr = "���g";
				i = 1;
				break;
				
			case 5:
				resultLabel.setText("��");
				resultStr = "��";
				i = 2;
				break;
		}
		//SE�̍Đ�
		se.playSe();
		//��蒼���{�^��
		Button backButton = (Button)findViewById(R.id.goBack);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ����ʂ̃A�N�e�B�r�e�B�I��
				finish();
			}
		});

		//���ʕۑ��{�^��
		Button saveButton = (Button)findViewById(R.id.save_button);
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveData();
			}
		});
	}
	// �ۑ�
	private void saveData() {
		SharedPreferences.Editor sp = getSharedPreferences("com.example.fortune_telling2", 0).edit();
		sp.putString("SAVE_DATA", resultStr);
		Toast.makeText(SubActivity.this, "�ۑ����܂���", Toast.LENGTH_SHORT).show();
	}
	
		
}
