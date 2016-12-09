package com.example.paulaanndroid.myfirstapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


/**
 * Created by Paula Ann on 12/4/2016.
 */

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            showResults(query);
        }
    }

    private void showResults(String query) {
        System.out.println("Search query: " + query);

        WebView starWebView = (WebView) findViewById(R.id.webview);
        starWebView.getSettings().setJavaScriptEnabled(true);
        SearchParser searchParser = new SearchParser();
        if (searchParser.parseQuery(query) != null) {
            TextView searchTextView = (TextView) findViewById(R.id.query);;
            if (searchParser.getElement("status").equals("0")) {
                searchTextView.setText(query);
            }
        }
    }
}