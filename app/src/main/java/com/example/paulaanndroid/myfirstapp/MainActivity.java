package com.example.paulaanndroid.myfirstapp;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.annotation.SuppressLint;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

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
        int width = size.x/divisor - widthPadding;
        int height = size.y/divisor - heightPadding;

        String data = "<IFRAME SRC=\"http://server1.sky-map.org/skywindow?ra=00 42 32&de=41 19 53&zoom=4\" WIDTH=" +
                width + " HEIGHT=" + height + "></IFRAME>";
        myWebView.loadData(data, "text/html", null);
        //myWebView.loadUrl("http://server1.sky-map.org/?locale=EN");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
