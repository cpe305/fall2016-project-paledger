package com.example.paulaanndroid.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.annotation.SuppressLint;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //WebView myWebView = (WebView) findViewById(R.id.webview);
        //String data = "<IFRAME SRC='http://server1.sky-map.org/skywindow?ra=00 42 32&de=41 19 53&zoom=4' WIDTH=400 HEIGHT=320' WIDTH=400 HEIGHT=320></IFRAME>";
        //myWebView.loadData(data, "text/html", null);
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
