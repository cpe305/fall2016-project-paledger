package com.example.paulaanndroid.myfirstapp;
/**
 * Created by Paula Ann on 10/26/2016.
 */

import android.webkit.WebView;

public class StarSearchView implements StarView {
    private URLComposer urlComposer;
    private WebView view;

    public StarSearchView() {
        urlComposer = new SearchURLComposer();
    }

    public void refresh() {
    }
}
