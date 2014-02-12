package me.risky.jingdong.adapter;

import java.util.ArrayList;
import java.util.List;

import me.risky.jingdong.base.AbsBaseListItemService;

import org.androidannotations.annotations.EBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

@EBean
public class ListItemAdapter extends BaseAdapter {
	
	private List<Object> list;
	private AbsBaseListItemService service;

	public ListItemAdapter(Context c) {
		super();
		list = new ArrayList<Object>();
	}
	
	public void setService(AbsBaseListItemService service){
		this.service = service;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public void addList(List<Object> list) {
		this.list.addAll(list);
	}

	public void clearList() {
		this.list.clear();
	}

	public List<Object> getList() {
		return list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return service.getView(position, convertView, parent, list.get(position));
	}

}