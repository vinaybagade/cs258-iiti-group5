package com.example.identifyu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class tabadapter extends FragmentPagerAdapter {

	public tabadapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch(arg0){
		case 1: 
			return new Gesturerecogonistion();
		case 0:
			return new Useradd();
		case 2:
			return new Theviewpage();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
