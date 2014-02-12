package me.risky.jingdong.activity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import me.risky.jingdong.R;
import me.risky.jingdong.adapter.ListItemAdapter;
import me.risky.jingdong.bean.Activity;
import me.risky.jingdong.service.ActivityItemService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import android.os.Bundle;
import android.util.Log;

import com.flavienlaurent.notboringactionbar.NoBoringActionBarActivity;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.mobile.WarePromotionActivitiesListGetRequest;
import com.jd.open.api.sdk.request.price.WarePriceGetRequest;
import com.jd.open.api.sdk.response.mobile.WarePromotionActivitiesListGetResponse;
import com.jd.open.api.sdk.response.price.WarePriceGetResponse;

@EActivity
public class MainActivity extends NoBoringActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//在父类初始化之前
    	setContentView(R.layout.activity_noboringactionbar);
        super.onCreate(savedInstanceState);
        
        setupListView();
    }

    private void setupListView(){
//    	ArrayList<String> FAKES = new ArrayList<String>();
//        for (int i = 0; i < 1000; i++) {
//            FAKES.add("entry " + i);
//        }
//        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FAKES)
        
        ListItemAdapter adapter = new ListItemAdapter(this);
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < 10; i ++){
        	Activity activity = new Activity();
        	activity.setTitle("Title" + i);
        	list.add(activity);
        }
        adapter.setList(list);
        adapter.setService(new ActivityItemService(this));
        
        setAdapter(adapter);
        
        executeGet();
    }
    
    @Background
    void executeGet(){
    	JdClient client=new DefaultJdClient(
    			"jingdong.union.promotionactivity.query",
    			null,
    			"131AEA2812954FA980DEFD65941F7571",
    			"fd5f2acce2e2412282ba9547b2f9a171");
//    	WarePriceGetRequest request=new WarePriceGetRequest();
//    	request.setSkuId( "jingdong" );
//    	WarePriceGetResponse response=client.execute(request);
    	
    	WarePromotionActivitiesListGetRequest request = new WarePromotionActivitiesListGetRequest();
    	request.setTimestamp(new SimpleDateFormat("yyyy-MM-ddHH:mm:ss", Locale.CHINA).format(new Date()));
    	request.setPage(1);
    	request.setPageSize(10);
    	try {
			WarePromotionActivitiesListGetResponse reponse = client.execute(request);
			Log.d("Http", reponse.toString());
		} catch (JdException e) {
			e.printStackTrace();
		}
    	Log.d("Http", "end");
    }
}
