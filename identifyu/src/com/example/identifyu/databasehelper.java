package com.example.identifyu;



import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper {
	private static final String TABLENAME="cordinate";
	private static final int VERSION =2;
	private static final String ID="_id";
	private static final String NAME="NAME";
	private static final String INTX="INITIALX";
	private static final String INTY="INITIALY";
	private static final String FINX="FINALX";
	private static final String FINY="FINALY";
	private static final String DIST="DISTANCE_MOVED";
	private static final String TIME="SCROLL_TIME";
	private databaseworker dbw;
	private SQLiteDatabase database;
	
	public databasehelper(Context c){
		dbw=new databaseworker(c);
		database=dbw.getWritableDatabase();
		
	}
	private class databaseworker extends SQLiteOpenHelper{
	

		public databaseworker(Context context) {
			super(context, "coordinate.db", null, VERSION);
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE table "+TABLENAME+"( _id INTEGER PRIMARY KEY AUTOINCREMENT , "+NAME+" TEXT, "+INTX+" REAL, "+INTY+" REAL, "+FINX+" REAL, "+FINY+" REAL, "+DIST+" REAL, "+TIME+" REAL)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
			onCreate(db);
			
		}
		
		
	}
	public void saverecords(String name,float intx, float inty,float finx,float finy,float dist,float time){
		ContentValues values=new ContentValues();
		values.put(NAME, name);
		values.put(INTX, intx);
		values.put(INTY, inty);
		values.put(FINX,finx);
		values.put(FINY,finy);
		values.put(DIST,dist);
		values.put(TIME,time);
		database.insert(TABLENAME, null, values);
		
	}
	
	public Cursor getRecord(String name){
		return database.rawQuery("SELECT _id, "+INTX+", "+INTY+", "+FINX+", "+FINY+", "+DIST+", "+TIME+" FROM "+TABLENAME+" where "+NAME+"='"+name+"';", null);
		
	}

}
