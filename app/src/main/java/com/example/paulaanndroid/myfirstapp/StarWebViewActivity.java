package com.example.paulaanndroid.myfirstapp;
import com.example.paulaanndroid.myfirstapp.R.*;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;

/**
 * Created by Paula Ann on 12/3/2016.
 */

public class StarWebViewActivity extends AppCompatActivity {
    private WebView starWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int height = this.getWindow().getDecorView().getBottom();

        System.out.println(height);
        String html = "<IFRAME SRC=\"http://server1.sky-map.org/skywindow?star=polaris WIDTH=400\"" + "HEIGHT=400" + "></IFRAME>";

        String url = "http://www.sky-map.org";
        starWebView = (WebView) findViewById(R.id.webview);
        starWebView.getSettings().setJavaScriptEnabled(true);
        //starWebView.setPadding(0, 0, 0, 0);
        //starWebView.loadUrl(url);
        starWebView.loadData(html, "text/html", null);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("onCreateOptionsMenu");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
            System.out.println("onOptionsItemSelected");
            return true;
        }
        return false;
    }
}
