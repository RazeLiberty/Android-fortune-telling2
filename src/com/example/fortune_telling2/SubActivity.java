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
	public static String load_data;	//�f�[�^�ǂݏo��
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout);
        //�w�i�F������
		rl.setBackgroundColor(Color.BLACK);
		
		//�肢�����_������
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("��g");
				resultStr = "��g";
				break;
				
			case 2:
				resultLabel.setText("�g");
				resultStr = "�g";
				break;
				
			case 3:
				resultLabel.setText("���g");
				resultStr = "���g";
				break;
				
			case 4:
				resultLabel.setText("���g");
				resultStr = "���g";
				break;
				
			case 5:
				resultLabel.setText("��");
				resultStr = "��";
				break;
		}
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
	}
	
		
}
