package com.example.paulaanndroid.myfirstapp;
import com.example.paulaanndroid.myfirstapp.R.*;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;

import org.w3c.dom.Document;

/**
 * Created by Paula Ann on 12/3/2016.
 */

public class StarWebViewActivity extends AppCompatActivity {
    private WebView starWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        starWebView = (WebView) findViewById(R.id.webview);
        starWebView.getSettings().setJavaScriptEnabled(true);
        new DownloadXMLResponse().execute("andromeda");
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

    private class DownloadXMLResponse extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... queries) {
            SearchURLComposer composer = new SearchURLComposer();
            String url = composer.compose(queries[0]);
            return url;
        }

        protected void onPostExecute(String result) {
            System.out.println("HELLO");
            System.out.println(result);
            starWebView.loadUrl(result);
        }


    }
}
