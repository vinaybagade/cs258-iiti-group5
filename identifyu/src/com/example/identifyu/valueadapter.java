package com.example.identifyu;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class valueadapter extends CursorAdapter {
	

	public valueadapter(Context context, Cursor c) {
		super(context, c);
		
	}

	@Override
	public void bindView(View view,Context c,Cursor cursor) {
		
		
		TextView finx=(TextView)view.findViewById(R.id.finx);
		finx.setText(Float.toString(cursor.getFloat(3)));
		TextView finy=(TextView)view.findViewById(R.id.finy);
		finy.setText(Float.toString(cursor.getFloat(4)));
		TextView dist=(TextView)view.findViewById(R.id.dist);
		dist.setText(Float.toString(cursor.getFloat(5)));
		
	}
	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
		LayoutInflater inflater=LayoutInflater.from(arg2.getContext());
		return inflater.inflate(R.layout.databaseitem ,arg2, false);
	}

}
