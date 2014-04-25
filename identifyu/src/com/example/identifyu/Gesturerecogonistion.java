package com.example.identifyu;

import java.util.ArrayList;

import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Gesturerecogonistion extends Fragment implements OnGesturePerformedListener {
	String s = "";
	GestureLibrary mlib;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		 mlib=storelibrary.getstore(getActivity());
			
			GestureOverlayView gov=(GestureOverlayView)getActivity().findViewById(R.id.confirmgestures);
			gov.addOnGesturePerformedListener(this);
			Button confirm=(Button)getActivity().findViewById(R.id.confirmbutton);
			confirm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					if(s.equals("")){
						Toast.makeText(getActivity(),"No such User" , Toast.LENGTH_SHORT).show();
					}
					else{
					Toast.makeText(getActivity(),"User is:"+s , Toast.LENGTH_SHORT).show();
					s="";
					}
				}
			});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.confirmgesture, container,false);
	}

	@Override
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
		ArrayList<Prediction>pre=mlib.recognize(gesture);
		if(pre.size()>0){
			Prediction prezero=pre.get(0);
			if(prezero.score>6){
				
				s=prezero.name;
			}
		}
		
		
	}
	
}
