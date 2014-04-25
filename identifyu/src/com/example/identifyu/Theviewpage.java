package com.example.identifyu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Theviewpage extends Fragment implements OnClickListener{
	valueadapter va;
	ListView lv;
	databasehelper dbh;
	Button btn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_theviewpage,container,false); 
	}
	@Override
	public void onStart() {
		super.onStart();
		btn = (Button) getActivity().findViewById(R.id.Submit);
		btn.setOnClickListener(this);
		lv=(ListView)getActivity().findViewById(R.id.list);
		dbh=new databasehelper(getActivity());
	}
	@Override
	public void onClick(View arg0) {
		if(arg0.getId() == R.id.Submit){
			EditText et=(EditText)getActivity().findViewById(R.id.inputgiven);
			String s=et.getText().toString();
			va=new valueadapter(getActivity(),dbh.getRecord(s));
			lv.setAdapter(va);
		}
		
	}
	

}
