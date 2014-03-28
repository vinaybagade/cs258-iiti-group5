package com.example.identifyu;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class ListObject {
	int imagid;
	String name;
	public ListObject(int id,String s){
		imagid=id;
		name=s;
	}
	public int getId(){
		return imagid;
	}
	public String getName(){
		return name;
	}

}
