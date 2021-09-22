package com.aozoradev.wbwwb;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.content.Intent;

public class MainActivity extends Activity {
	
   private AlertDialog.Builder dialog;
   private String[] list = {"English", "Indonesia"};
   private ArrayAdapter<String> adapter;
   private ListView listView;
   private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		dialog = new AlertDialog.Builder(this);
	}
	
	private void initializeLogic() {
		View rowList = getLayoutInflater().inflate(R.layout.row, null);
		listView = rowList.findViewById(R.id.listview1);
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		dialog.setView(rowList);
		listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						switch (position) {
								case 0:
								intent.setClass(getApplicationContext(), GameEnActivity.class);
								startActivity(intent);
								finish();
								break;
								case 1:
								intent.setClass(getApplicationContext(), GameIdActivity.class);
								startActivity(intent);
								finish();
								break;
						}
				    }
		});
		dialog.setTitle("Select Language");
		dialog.setCancelable(false);
		dialog.create().show();
	}
	
}