package com.example.identifyu;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class Custompager extends ViewPager {
	public boolean enabled;
	public Custompager(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.enabled=true;
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if(this.enabled){
			return super.onInterceptTouchEvent(arg0);
		}
		return false;
	}
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		if(this.enabled){
			return super.onTouchEvent(arg0);
		}
		return false;
	}
	public void setenabled(boolean enabled){
		this.enabled=enabled;
	}
	
}
