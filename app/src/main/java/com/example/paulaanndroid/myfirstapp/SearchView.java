package com.example.paulaanndroid.myfirstapp;
/**
 * Created by Paula Ann on 10/26/2016.
 */

import android.webkit.WebView;

public class SearchView implements StarView {
    private URLComposer urlComposer;
    private WebView view;

    public SearchView() {
        urlComposer = new SearchURLComposer();
    }

    public void refresh() {
    }
}
