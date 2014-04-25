package com.example.identifyu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Useradd extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.adduser,container,false);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		ImageButton b=(ImageButton)getActivity().findViewById(R.id.badd);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getActivity(), Fullgesturerecogonition.class);
				EditText tv=(EditText)getActivity().findViewById(R.id.username);
				String s=tv.getText().toString();
				if(s.equals("")){
					Toast.makeText(getActivity(),"Enter a valid username" , Toast.LENGTH_SHORT).show();
				}
				else{
					intent.putExtra("username", s);
					startActivity(intent);
				}
				
			}
		});
	}

	
}
