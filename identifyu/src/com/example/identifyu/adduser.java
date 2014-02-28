package com.example.identifyu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class adduser extends Activity{
	View[] view = new View[7];
	long starttime,elapsetime;
	float startx,endx,starty,endy;double distancemoved;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listofimageviews);
		int []imaarr={R.id.image1,R.id.image2,R.id.image3,R.id.image4,R.id.image5,
				R.id.image6,R.id.image7};
		
		for(int i=0;i<7;i++){
			view[i]=(View)findViewById(imaarr[i]);
			view[i].setOnTouchListener(new OnTouchListener() {
				
				@Override
				
				public boolean onTouch(View v, MotionEvent event) {
					if(event.getAction()==MotionEvent.ACTION_DOWN){
						starttime=System.nanoTime();
						startx=event.getRawX();
						starty=event.getRawY();
						Toast.makeText(getApplicationContext(),"INITIAL x:"+startx+" INITIAL Y:"+starty , Toast.LENGTH_SHORT).show();
					}
					else if(event.getAction()==MotionEvent.ACTION_UP){
						elapsetime=System.nanoTime()-starttime;
					}
					else if(event.getAction()==MotionEvent.ACTION_MOVE){
						endx=event.getRawX();
						endy=event.getRawY();
						distancemoved=Math.sqrt(Math.pow(endx-startx, 2)+Math.pow(endy-starty, 2));
						Toast.makeText(getApplicationContext(),"FINAL x:"+endx+" FINAL Y:"+endy , Toast.LENGTH_SHORT).show();
					}
					Toast.makeText(getApplicationContext()," DISTANCE MOVED:"+distancemoved+" TIME ELAPSED IN SCROLL:"+elapsetime, Toast.LENGTH_SHORT).show();
					
					return true;
				}
			});
		}
		
	}
	@Override
	protected void onPause(){
		for(int i = 0; i < 7;i++){
			view[i].setOnTouchListener(null);
			
		}
		super.onPause();
		
	}
	@Override
	protected void onDestroy() {
		
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}
	

	
	
}
