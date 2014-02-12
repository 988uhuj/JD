package me.risky.jingdong.service;

import me.risky.jingdong.R;
import me.risky.jingdong.base.AbsBaseListItemService;
import me.risky.jingdong.bean.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityItemService extends AbsBaseListItemService{
	
	private ViewHolder holder;
//	private ImageLoaderHelper imageLoaderHelper;
	
	public ActivityItemService(Context context) {
		super(context);
//		imageLoaderHelper = new ImageLoaderHelper(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent, Object item){
		if (null == convertView) {
			convertView = layoutInflater.inflate(R.layout.list_item_news, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.content = (TextView) convertView.findViewById(R.id.content);
//			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.newsImg = (ImageView) convertView.findViewById(R.id.newsImg);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (null != item) {
			Activity newsItem = (Activity) item;
			holder.title.setText(newsItem.getTitle());
//			holder.content.setText(newsItem.getContent());
//			holder.date.setText(newsItem.getDate());
//			if(newsItem.getImgLink() != null){
////				imageLoaderHelper.display(newsItem.getImgLink(), holder.newsImg);
//				// TODO
//				holder.newsImg.setVisibility(View.VISIBLE);
//			}else{
////				holder.newsImg.setVisibility(View.GONE);
//			}
			holder.newsImg.setImageResource(R.drawable.t1);
		}
		return convertView;
	}
	
	private class ViewHolder {
		TextView title;
		TextView content;
//		TextView date;
		ImageView newsImg;
	}
}
