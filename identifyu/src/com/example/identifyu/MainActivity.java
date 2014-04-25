package com.example.identifyu;



import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements TabListener {

	private Custompager viewPager;
    private tabadapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = {"Add User","Authenticate","View"};
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	viewPager=(Custompager)findViewById(R.id.page);
	actionBar=getActionBar();
	mAdapter = new tabadapter(getSupportFragmentManager());
	viewPager.setAdapter(mAdapter);
	actionBar.setHomeButtonEnabled(false);
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
        viewPager.setOnPageChangeListener(new Custompager.OnPageChangeListener() {
        	 
            @Override
            public void onPageSelected(int position) {
                
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
 
}


@Override
public boolean onMenuItemSelected(int featureId, MenuItem item) {
	if(item.getItemId()==R.id.enable){
		viewPager.setenabled(true);
	}
	if(item.getItemId()==R.id.disable){
		viewPager.setenabled(false);
	}
	return super.onMenuItemSelected(featureId, item);
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
	 super.onCreateOptionsMenu(menu);
	 MenuInflater inflater=getMenuInflater();
	 inflater.inflate(R.menu.enabledisable, menu);
	 return true;
}


@Override
public void onTabReselected(Tab tab, FragmentTransaction ft) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
	viewPager.setCurrentItem(tab.getPosition());
	
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	// TODO Auto-generated method stub
	
}

	
	
}
