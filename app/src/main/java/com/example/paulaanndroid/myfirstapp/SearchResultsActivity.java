package com.example.paulaanndroid.myfirstapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


/**
 * Created by Paula Ann on 12/4/2016.
 */

public class SearchResultsActivity extends AppCompatActivity {
    private WebView starWebView;
    private TextView searchTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        starWebView = (WebView) findViewById(R.id.webview);
        starWebView.getSettings().setJavaScriptEnabled(true);
        searchTextView = (TextView) findViewById(R.id.query);

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

        searchTextView.setText(query);
        new DownloadXMLResponse().execute(query);
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
            starWebView.setWebViewClient(new StarWebViewClient());

        }
    }

    private class StarWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webview, String url) {
            webview.loadUrl(url);
            return true;
        }
    }
}