package com.example.identifyu;

import java.io.File;

import android.content.Context;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;

public class storelibrary {
	
	private static GestureLibrary sstore;
	public static GestureLibrary  getstore(Context c){
		 if (sstore == null) {
	           File mfile = new File(c.getFilesDir(), "gestures");
	            sstore = GestureLibraries.fromFile(mfile);
	            
	        }
		 sstore.load();

	     return sstore;
	}
	

}
