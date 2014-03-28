package com.example.identifyu;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Fullgesturerecogonition extends Activity {
	private Gesture mgesture;
	public Button donebutton;
	public static final float LENGTH_THRESHOLD=120f;
	private final File mfile=new File(Environment.getExternalStorageDirectory(),"gestures"); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gesturepad);
		GestureOverlayView overlay=(GestureOverlayView)findViewById(R.id.gestures);
		donebutton=(Button)findViewById(R.id.finishbutton);
		overlay.addOnGestureListener(new GesturesProcessor());
	}
	void onfinishbuttonclicked(View view){
		if(mgesture!=null){
			GestureLibrary lib=GestureLibraries.fromFile(mfile);
			lib.addGesture(, gesture)
		}
		
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if(mgesture!=null){
			outState.putParcelable("gesture", mgesture);
		}
	}
	

	@Override
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
	

}
