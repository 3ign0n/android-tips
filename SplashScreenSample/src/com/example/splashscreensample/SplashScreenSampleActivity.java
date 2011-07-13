package com.example.splashscreensample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenSampleActivity extends Activity {
	private Activity mMe;
	private static final String TAG = "SPLASH";
	private ImageView mImageView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mMe = this;
        mImageView = (ImageView)findViewById(R.id.imageView1);
        new LongTimeTask().execute();
    }
	
	private class LongTimeTask extends AsyncTask {

		@Override
		protected Object doInBackground(Object... paramArrayOfParams) {
			// 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Object result) {
	        Animation anim = AnimationUtils.loadAnimation(mMe, R.anim.fadeout);
	        anim.setAnimationListener(new AnimationListener(){
				@Override
				public void onAnimationStart(Animation paramAnimation) {
					// Nothing to do
					Log.d(TAG, "onAnimationEnd");
				}

				@Override
				public void onAnimationEnd(Animation paramAnimation) {
					// 
					Log.d(TAG, "onAnimationEnd");
					mImageView.setVisibility(View.GONE);
				}

				@Override
				public void onAnimationRepeat(Animation paramAnimation) {
					// Nothing to do
					Log.d(TAG, "onAnimationEnd");
				}
	        	
	        });
	        mImageView.setAnimation(anim);
		}
	}
}