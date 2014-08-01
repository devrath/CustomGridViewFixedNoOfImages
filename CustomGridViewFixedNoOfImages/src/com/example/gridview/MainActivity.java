package com.example.gridview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.CustomGridViewFixedNoOfImages.R;
import com.example.gridview.customcontrols.HFGridView;

public class MainActivity extends Activity {

	private TableLayout table_layout = null;
	private ArrayList<LinkedHashMap<String,CharSequence>> mListLayoutData;
	private LinkedHashMap<String, CharSequence> objMap;
	private HFGridView gridView;
	private int maxCol=0;
	private int imageWidth=100;
	private int imageHeight=70;
	private int outerPaddingAdjust=0;
	private int minPadding=5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mListLayoutData=new ArrayList<LinkedHashMap<String,CharSequence>>();
		objMap = new LinkedHashMap<String, CharSequence>();

		gridView = (HFGridView) findViewById(R.id.gridView);
		table_layout = (TableLayout)findViewById(R.id.tableLayout);

		//Always set the number of columns to one
		gridView.setNumColumns(1);

		//Get the Width and the height of the screeen
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		Configuration config = getResources().getConfiguration();
		if (config.orientation == Configuration.ORIENTATION_PORTRAIT)
		{
			//Portrait Mode
			maxCol=2;
			imageWidth=(int) Math.floor(((metrics.widthPixels-(minPadding*(maxCol+1)))/maxCol));
			imageHeight=(int) ((metrics.widthPixels/maxCol)/(10/6.5));
			gridView.setColumnWidth(metrics.widthPixels);
		}
		else if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
			//Landscape Mode
			maxCol=3;
			imageWidth=(int) Math.floor(((metrics.widthPixels-(minPadding*(maxCol+1)))/maxCol));
			imageHeight=(int) ((metrics.widthPixels/maxCol)/(10/6.5));
			gridView.setColumnWidth(metrics.widthPixels);
		}

		View gridViewHeader = getHeader("Header");
		View gridViewFooter = getFooter("Footer");

		gridView.addHeaderView(gridViewHeader);
		gridView.addFooterView(gridViewFooter);

		//Add the data for the gridview
		AddDataToGridView();

		GridAdapter gridAdapter=new GridAdapter(MainActivity.this,mListLayoutData,outerPaddingAdjust,imageWidth,imageHeight);	

		gridView.setAdapter(gridAdapter);

	}

	private void AddDataToGridView() {

		LinkedHashMap<String,Integer> headerArr=new LinkedHashMap<String,Integer>();

		headerArr.put("SubHeader-1",5);
		headerArr.put("SubHeader-2",8);
		headerArr.put("SubHeader-3",7);

		for (Entry<String, Integer> entry : headerArr.entrySet()) {
			String headetTxt = entry.getKey();	
			int totalItem = entry.getValue();	
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put(headetTxt,"HEADER");		
			mListLayoutData.add(objMap);

			objMap = new LinkedHashMap<String, CharSequence>();
			
			int rowCnt=0;
			int colCnt=0;
			int itemCnt=1;
			int maxRow=(int) Math.ceil((Double.valueOf(totalItem)/Double.valueOf(maxCol)));
			
			for(rowCnt=1;rowCnt<=maxRow;rowCnt++){//no of rows
				
				objMap = new LinkedHashMap<String, CharSequence>();
				for(colCnt=1;colCnt<=maxCol;colCnt++){//no of colmns
					
					objMap.put("Item"+itemCnt+"", headetTxt);// Add the item
					if(itemCnt>=totalItem)break;
					itemCnt++;// Increment item count
				}
				mListLayoutData.add(objMap);
				if(itemCnt>totalItem)break;
			}
		}
		Log.i("","");
	}

	private View getHeader(String text) {
		View header = getLayoutInflater().inflate(R.layout.header, null);
		TextView textView = (TextView) header.findViewById(R.id.headerTextView);
		textView.setText(text);
		return header;
	}

	private View getFooter(String text) {
		View footer = getLayoutInflater().inflate(R.layout.footer, null);
		TextView textView = (TextView) footer.findViewById(R.id.footerTextView);
		textView.setText(text);
		return footer;
	}
}
