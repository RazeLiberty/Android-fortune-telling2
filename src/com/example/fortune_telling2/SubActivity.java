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
		
		
		Random r = new Random();
		int n = r.nextInt(3) + 1;
		TextView textView01 = (TextView) findViewById(R.id.textView1);  
		switch(n){
			case 1:
				textView01.setText("��g");
				break;
				
			case 2:
				textView01.setText("�g");
				break;
				
			case 3:
				textView01.setText("��");
				break;
		}

		Button btn = (Button)findViewById(R.id.button02_id);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ����ʂ̃A�N�e�B�r�e�B�I��
				finish();
			}
			});
	}
}