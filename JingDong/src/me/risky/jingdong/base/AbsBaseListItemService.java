package me.risky.jingdong.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbsBaseListItemService {
	protected LayoutInflater layoutInflater;
	protected Context context;
	
	public AbsBaseListItemService(Context context){
		this.context = context;
		layoutInflater = (LayoutInflater) LayoutInflater.from(context);
	}
	
	public abstract View getView(int position, View convertView, ViewGroup parent, Object item);
}
