package com.example.fortune_telling2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout);
        //�w�i�F������
		rl.setBackgroundColor(Color.BLACK);
		
		loadData();
		
		
	}
	// �ǂݍ���
		private void loadData() {
			SharedPreferences sp = getSharedPreferences("com.example.fortune_telling2", 0);
			SubActivity.load_data = sp.getString("SAVE_DATA", SubActivity.load_data);
		    Toast.makeText(ThirdActivity.this, "�ǂ݂������f�[�^" + SubActivity.load_data, Toast.LENGTH_SHORT).show();
		}
}
