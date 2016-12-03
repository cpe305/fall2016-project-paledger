package com.example.paulaanndroid.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Paula Ann on 12/3/2016.
 */

public class StarWebViewActivity extends Activity {
    private WebView starWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        starWebView = (WebView) findViewById(R.id.webview);
        starWebView.getSettings().setJavaScriptEnabled(true);
        starWebView.loadUrl("https://www.google.com");
        starWebView.setWebViewClient(new StarWebViewClient());
    }

    private class StarWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webview, String url) {
            webview.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && starWebView.canGoBack()) {
            starWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
