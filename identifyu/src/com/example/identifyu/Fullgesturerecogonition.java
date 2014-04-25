package com.example.identifyu;



import java.util.concurrent.ThreadPoolExecutor;

import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Fullgesturerecogonition extends Activity {
	private Gesture mgesture;
	public Button donebutton;
	public static final float LENGTH_THRESHOLD=120.0f;
	public databasehelper dbh;
	float starttime=0,elapsetime=0;
	float startx=0,endx=0,starty=0,endy=0;float distancemoved=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gesturepad);
		dbh=new databasehelper(this);
		GestureOverlayView overlay=(GestureOverlayView)findViewById(R.id.gestures);
		overlay.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					starttime=System.nanoTime();
					startx=event.getRawX();
					starty=event.getRawY();
	
				}
				else if(event.getAction()==MotionEvent.ACTION_UP){
					elapsetime=System.nanoTime()-starttime;
				}
				else if(event.getAction()==MotionEvent.ACTION_MOVE){
					endx=event.getRawX();
					endy=event.getRawY();
					distancemoved=(float)Math.sqrt(Math.pow(endx-startx, 2)+Math.pow(endy-starty, 2));
					
				}
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						Intent intent=getIntent();
						String s=intent.getStringExtra("username");
						startx=Float.parseFloat(String.format("%.4g%n", startx));
						starty=Float.parseFloat(String.format("%.4g%n", starty));
						endx=Float.parseFloat(String.format("%.4g%n", endx));
						endy=Float.parseFloat(String.format("%.4g%n", endy));
						distancemoved=Float.parseFloat(String.format("%.4g%n", distancemoved));
						elapsetime=Float.parseFloat(String.format("%.4g%n", elapsetime));
								
						dbh.saverecords(s, startx, starty, endx, endy, distancemoved, elapsetime);
						
					}
				}).start();
						
				
				return true;
			}
		});
		overlay.addOnGestureListener(new GesturesProcessor());
		donebutton=(Button)findViewById(R.id.finishbutton);
	}
	public void onfinishbuttonclicked(View view){
		if(mgesture!=null){
			GestureLibrary lib=storelibrary.getstore(this);
			Intent intent=getIntent();
			String s=intent.getStringExtra("username");
			lib.addGesture(s, mgesture);
			lib.save();
			Toast.makeText(getApplicationContext(), "Saved in SD card", Toast.LENGTH_SHORT).show();
		
		}
	}	

	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    if (mgesture != null) {
	        outState.putParcelable("gesture", mgesture);
	    }
	}
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	    super.onRestoreInstanceState(savedInstanceState);

	    mgesture = savedInstanceState.getParcelable("gesture");
	    if (mgesture != null) {
	        final GestureOverlayView overlay =
	                (GestureOverlayView) findViewById(R.id.gestures);
	        overlay.post(new Runnable() {
	            public void run() {
	                overlay.setGesture(mgesture);
	            }
	        });
	        donebutton.setEnabled(true);
	    }
	}

	
	private class GesturesProcessor implements GestureOverlayView.OnGestureListener {
	    public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
	        donebutton.setEnabled(false);
	        mgesture = null;
	    }
	    public void onGesture(GestureOverlayView overlay, MotionEvent event) {
	    }

	    public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
	        mgesture = overlay.getGesture();
	        if (mgesture.getLength() < LENGTH_THRESHOLD) {
	            overlay.clear(false);
	        }
	        donebutton.setEnabled(true);
	    }
	    public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {
	    }
	}
	class data implements Runnable{

		@Override
		public void run() {
			
			
		}
	}
	

}
