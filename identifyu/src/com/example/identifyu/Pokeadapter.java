package com.example.identifyu;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.R.raw;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Pokeadapter extends BaseAdapter {
	ArrayList<ListObject> items=new ArrayList<ListObject>();
	public Pokeadapter(){
		items.add(new ListObject(R.drawable.bulbasaur, "bulbasaur"));
		items.add(new ListObject(R.drawable.butterfree, "butterfree"));
		items.add(new ListObject(R.drawable.caterpie, "caterpie"));
		items.add(new ListObject(R.drawable.charizard, "charizard"));
		items.add(new ListObject(R.drawable.charmander, "charmander"));
		items.add(new ListObject(R.drawable.charmeleon, "charmeleon"));
		items.add(new ListObject(R.drawable.ivysaur, "ivysaur"));
		items.add(new ListObject(R.drawable.kakuna, "kakuna"));
		items.add(new ListObject(R.drawable.arceus, "arceus"));
		items.add(new ListObject(R.drawable.articuno, "articuno"));
		items.add(new ListObject(R.drawable.blastoise, "blastoise"));
		items.add(new ListObject(R.drawable.giratina, "giratina"));
		items.add(new ListObject(R.drawable.cresselia, "cresselia"));
		items.add(new ListObject(R.drawable.darkrai, "darkrai"));
		items.add(new ListObject(R.drawable.dragonite, "dragonite"));
		items.add(new ListObject(R.drawable.gengar, "gengar"));
		items.add(new ListObject(R.drawable.deoxys, "deoxys"));
		items.add(new ListObject(R.drawable.groudon, "groudon"));
		items.add(new ListObject(R.drawable.hooh, "hooh"));
		items.add(new ListObject(R.drawable.lugia, "lugia"));
		items.add(new ListObject(R.drawable.mew, "mew"));
		items.add(new ListObject(R.drawable.mewtwo, "mewtwo"));
		items.add(new ListObject(R.drawable.moltres, "moltres"));
		items.add(new ListObject(R.drawable.zapdos, "zapdos"));
		items.add(new ListObject(R.drawable.rayquaza, "rayquaza"));
		items.add(new ListObject(R.drawable.pidgeotto, "pidgeotto"));
		items.add(new ListObject(R.drawable.tyranitar, "tyranitar"));
		items.add(new ListObject(R.drawable.pikachu, "pikachu"));
	}
	
	@Override
	public int getCount() {
		
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		
		return items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		if(convertView==null){
			LayoutInflater l=LayoutInflater.from(arg2.getContext());
			convertView=l.inflate(R.layout.listviewitem, arg2, false);
		}
		ListObject lo=items.get(arg0);
		ImageView im=(ImageView)convertView.findViewById(R.id.imagview);
		im.setImageResource(lo.getId());
		TextView tv=(TextView)convertView.findViewById(R.id.nameview);
		tv.setText(lo.getName());
		return convertView;
	}

}
