package com.example.identifyu;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class userdatacollection extends Activity {
	ArrayList<Float> values;
	ListView view;
	public static final int requestcode=1;
	Pokeadapter pa;
	long starttime,elapsetime;
	float startx,endx,starty,endy;double distancemoved;
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 super.onCreateOptionsMenu(menu);
		 MenuInflater mi=getMenuInflater();
		 mi.inflate(R.menu.secondtest, menu);
		 return true;
	}
	

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getItemId()==(R.id.ST)){
			int
			Intent intent=new Intent(this, Gesturerecogonistion.class);
			startActivityForResult(intent, requestcode);
		}
		return true;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokemon_listview);
		view=(ListView)findViewById(R.id.pokeid);
		pa=new Pokeadapter();
		view.setAdapter(pa);
		view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				arg1.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View arg0, MotionEvent event) {
						if(event.getAction()==MotionEvent.ACTION_DOWN){
							starttime=System.nanoTime();
							startx=event.getRawX();
							starty=event.getRawY();
							//Toast.makeText(getApplicationContext(),"INITIAL x:"+startx+" INITIAL Y:"+starty , Toast.LENGTH_SHORT).show();
						}
						else if(event.getAction()==MotionEvent.ACTION_UP){
							elapsetime=System.nanoTime()-starttime;
						}
						else if(event.getAction()==MotionEvent.ACTION_MOVE){
							endx=event.getRawX();
							endy=event.getRawY();
							distancemoved=Math.sqrt(Math.pow(endx-startx, 2)+Math.pow(endy-starty, 2));
							//Toast.makeText(getApplicationContext(),"FINAL x:"+endx+" FINAL Y:"+endy , Toast.LENGTH_SHORT).show();
						}
						//Toast.makeText(getApplicationContext()," DISTANCE MOVED:"+distancemoved+" TIME ELAPSED IN SCROLL:"+elapsetime, Toast.LENGTH_SHORT).show();
						
						return true;
						
					}
				});
				
			}
		});
	}
		
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==requestcode){
			if(resultCode==RESULT_OK){
				Intent intent=getIntent();
				String gesturedata=data.getStringExtra("gesture");
				intent.putExtra("gesture", gesturedata);
				this.setResult(RESULT_OK, intent);
				finish();
			}
		}
		
	}


	@Override
	protected void onPause(){
		
		view.setOnTouchListener(null);
		super.onPause();
		
	}
}
