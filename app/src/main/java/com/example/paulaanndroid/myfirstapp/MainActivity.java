package com.example.paulaanndroid.myfirstapp;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.EditText;
import android.util.DisplayMetrics;

import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.annotation.SuppressLint;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import android.support.v7.app.AppCompatActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

class MainActivity extends AppCompatActivity {

	//private final static String DARKBLUE = "#3F51B5";
    private final static int widthPadding = 25;
    private final static int heightPadding = 200;
    private final static int divisor = 3;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);



        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        //int width = size.x/divisor - widthPadding;
        //int height = size.y/divisor - heightPadding;


        myWebView.setInitialScale(1);
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON_DEMAND);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        String html = "<IFRAME SRC=\"http://server1.sky-map.org/skywindow?object=M100&zoom=8&img_source=SDSS\" WIDTH=400 HEIGHT=320></IFRAME>";
        String data = "<IFRAME SRC=\"http://server1.sky-map.org/skywindow?ra=00 42 32&de=41 19 53&zoom=4\" WIDTH=" +
                width + " HEIGHT=" + height + "></IFRAME>";
        myWebView.loadDataWithBaseURL("http://server1.sky-map.org/skywindow", html, "text/html", "UTF-8", null);
        //myWebView.loadUrl("http://server1.sky-map.org/?locale=EN");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = "";
        if (editText.getText() != null) {
            message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

}
