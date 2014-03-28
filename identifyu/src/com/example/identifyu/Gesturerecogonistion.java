package com.example.identifyu;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.identifyu.R;

public class Gesturerecogonistion extends Activity implements OnGesturePerformedListener {
	String s="";
	GestureLibrary mlib;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gesturepad);
		 mlib=GestureLibraries.fromRawResource(this, R.raw.gestures);
		if(!mlib.load()){
			finish();
		}
		GestureOverlayView gov=(GestureOverlayView)findViewById(R.id.gestures);
		gov.addOnGesturePerformedListener(this);
	}

	@Override
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
		ArrayList<Prediction>pre=mlib.recognize(gesture);
		if(pre.size()>0){
			Prediction prezero=pre.get(0);
			if(prezero.score>1){
				
				s=s+prezero.name;
			}
		}
		else{
			Toast.makeText(getApplicationContext(), "Not a valid gesture", Toast.LENGTH_SHORT).show();
		}
		
	}
	public void onfinishbuttonclicked(View view){
		Intent intent=getIntent();
		intent.putExtra("gesture", s);
		this.setResult(RESULT_OK,intent);
		finish();
		
	}
}
