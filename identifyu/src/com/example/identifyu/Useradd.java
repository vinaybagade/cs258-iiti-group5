package com.example.identifyu;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Useradd extends Activity {
	public static final int requestcode=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adduser);
	}
	public void onaddclicked(View view){
		Intent intent=new Intent(this, userdatacollection.class);
		EditText tv=(EditText)findViewById(R.id.username);
		String s=tv.getText().toString();
		if(s.equals("")){
			Toast.makeText(getApplicationContext(),"Enter a valid username" , Toast.LENGTH_SHORT).show();
		}
		else{
			intent.putExtra("username", s);
			startActivityForResult(intent, requestcode);
		}
	}
	public void oncancelclicked(View view){
		finish();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==requestcode){
			if(resultCode==RESULT_OK){
				
				Toast.makeText(getApplicationContext(), data.getStringExtra("gesture"), Toast.LENGTH_SHORT).show();
				
			}
			
		}
		
	}
	

}
