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
		
		//�肢�����_������
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("��g");
				break;
				
			case 2:
				resultLabel.setText("�g");
				break;
				
			case 3:
				resultLabel.setText("���g");
				break;
				
			case 4:
				resultLabel.setText("���g");
				break;
				
			case 5:
				resultLabel.setText("��");
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
				//�ۑ�
				android.content.SharedPreferences sp = getSharedPreferences("FortuneResult", MODE_PRIVATE);
				sp.edit().putString(resultLabel).commit();
				sp.edit().putInt("integer", 100).commit();
			}
		});
		
	}
}