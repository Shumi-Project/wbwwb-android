package com.shumiproject.wbwwb;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.view.WindowManager;
import android.view.Display;
import android.content.Context;

public class MainActivity extends Activity {
	
	private WebView webview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.game);
		initialize();
		startGame();
	}
	
	private void initialize() {
		webview1 = findViewById(R.id.webview1);
		WebSettings settings = webview1.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setAllowFileAccessFromFileURLs(true);
		settings.setAllowUniversalAccessFromFileURLs(true);
		webview1.setInitialScale(getScale(960, 540));
	}
	
	private void startGame() {
		webview1.loadUrl("file:///android_asset/index.html");
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
	}

	private int getScale(int i, int i2) {
	    Display defaultDisplay = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
	    defaultDisplay.getMetrics(displayMetrics);
		int i3 = displayMetrics.heightPixels;
        int i4 = displayMetrics.widthPixels;
		return (int) (Double.valueOf(Math.min(Double.valueOf(Double.valueOf((double) i3).doubleValue() / Double.valueOf((double) i2).doubleValue()).doubleValue(), Double.valueOf(Double.valueOf((double) i4).doubleValue() / Double.valueOf((double) i).doubleValue()).doubleValue())).doubleValue() * 100.0d);
	}
	
}
