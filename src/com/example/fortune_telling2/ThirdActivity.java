package com.example.fortune_telling2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout3);
        //�w�i�F������
		rl.setBackgroundColor(Color.BLACK);
		
		loadData();
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		
		//��蒼���{�^��
				Button backButton = (Button)findViewById(R.id.goBack);
				backButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// ����ʂ̃A�N�e�B�r�e�B�I��
						finish();
					}
				});
		
	}
	// �ǂݍ���
		private void loadData() {
			SharedPreferences sp = getSharedPreferences("com.example.fortune_telling2", 0);
			SubActivity.load_data = sp.getString("SAVE_DATA", SubActivity.load_data);
		    Toast.makeText(ThirdActivity.this, "�ǂ݂������f�[�^" + SubActivity.load_data, Toast.LENGTH_SHORT).show();
		}
}
