package com.aozoradev.wbwwb;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.view.Display;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class GameIdActivity extends Activity {
	
	private WebView webview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.game_id);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		webview1 = findViewById(R.id.webview1);
		WebSettings settings = webview1.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setAllowFileAccessFromFileURLs(true);
		settings.setAllowUniversalAccessFromFileURLs(true);
		webview1.setInitialScale(getScale(960, 540));
	}
	
	private void initializeLogic() {
		WebSettings settings = webview1.getSettings();
		settings.setJavaScriptEnabled(true); settings.setAllowFileAccessFromFileURLs(true); settings.setAllowUniversalAccessFromFileURLs(true); webview1.setInitialScale(getScale(960, 540));
		webview1.loadUrl("file:///android_asset/index_id.html");
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		webview1.clearCache(true);
		webview1.clearHistory();
		webview1.loadUrl("about:blank");
		webview1.removeAllViews();
		webview1.clearView();
		webview1.destroy();
		webview1=null;
		finish();
	}
	public void _thing() {
	}
	private int getScale(int i, int i2) {
		        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
		        DisplayMetrics displayMetrics = new DisplayMetrics();
		        defaultDisplay.getMetrics(displayMetrics);
		        int i3 = displayMetrics.heightPixels;
		        int i4 = displayMetrics.widthPixels;
		        return (int) (Double.valueOf(Math.min(Double.valueOf(new Double((double) i3).doubleValue() / new Double((double) i2).doubleValue()).doubleValue(), Double.valueOf(new Double((double) i4).doubleValue() / new Double((double) i).doubleValue()).doubleValue())).doubleValue() * 100.0d);
	}
	
}