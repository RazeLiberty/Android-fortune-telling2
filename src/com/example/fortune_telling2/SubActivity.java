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
import android.widget.Toast;

@SuppressLint("CommitPrefEdits") public class SubActivity extends Activity {
	public static String resultStr;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		
		RelativeLayout rl= (RelativeLayout)findViewById(R.id.relativeLayout2);
        //”wŒiF‚ğ•‚É
		rl.setBackgroundColor(Color.BLACK);
		
		
		
		//è‚¢ƒ‰ƒ“ƒ_ƒ€ˆ—
		Random r = new Random();
		int n = r.nextInt(5) + 1;
		final TextView resultLabel = (TextView) findViewById(R.id.result_text);
		switch(n){
			case 1:
				resultLabel.setText("‘å‹g");
				resultStr = "‘å‹g";
				break;
				
			case 2:
				resultLabel.setText("‹g");
				resultStr = "‹g";
				break;
				
			case 3:
				resultLabel.setText("’†‹g");
				resultStr = "’†‹g";
	
				break;
				
			case 4:
				resultLabel.setText("¬‹g");
				resultStr = "¬‹g";
				break;
				
			case 5:
				resultLabel.setText("‹¥");
				resultStr = "‹¥";
				break;
		}
		
		//‚â‚è’¼‚µƒ{ƒ^ƒ“
		Button backButton = (Button)findViewById(R.id.goBack);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Ÿ‰æ–Ê‚ÌƒAƒNƒeƒBƒrƒeƒBI—¹
				finish();
			}
		});

		//Œ‹‰Ê•Û‘¶ƒ{ƒ^ƒ“
		Button saveButton = (Button)findViewById(R.id.save_button);
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveData();
			}
		});
	}
	// •Û‘¶
	private void saveData() {
		SharedPreferences.Editor sp = getSharedPreferences("com.example.fortune_telling2", 0).edit();
		sp.putString("SAVE_DATA", resultStr);
		Toast.makeText(SubActivity.this, "•Û‘¶‚µ‚Ü‚µ‚½", Toast.LENGTH_SHORT).show();
	}
	
		
}
