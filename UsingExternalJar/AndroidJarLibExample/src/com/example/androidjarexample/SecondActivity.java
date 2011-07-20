package com.example.androidjarexample;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class SecondActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View paramView) {
				finish();
			}
		});
	}
}
