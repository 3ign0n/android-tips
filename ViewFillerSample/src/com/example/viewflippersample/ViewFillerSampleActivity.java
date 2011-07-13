package com.example.viewflippersample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ViewFillerSampleActivity extends Activity {
    private ViewFlipper mViewFlipper;
    private Activity mMe;
    private int mCurrentViewPosition = 0;
    private int mViewNum;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mMe = this;
        mViewFlipper = (ViewFlipper)findViewById(R.id.viewFlipperAnimation);
        mViewNum = mViewFlipper.getChildCount();
        Button prev = (Button)findViewById(R.id.buttonPrev);
        prev.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View paramView) {
				if (mCurrentViewPosition > 0) {
					mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mMe, R.anim.move_in_left));
					mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mMe, R.anim.move_out_right));
	                mViewFlipper.showPrevious();
	                mCurrentViewPosition--;
				}
			}
        });
        
        Button next = (Button)findViewById(R.id.buttonNext);
        next.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View paramView) {
				if (mCurrentViewPosition < mViewNum-1) {
					mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mMe, R.anim.move_in_right));
					mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mMe, R.anim.move_out_left));
					mViewFlipper.showNext();
	                mCurrentViewPosition++;
				}
			}
        });
        
    }
    
    
    
}