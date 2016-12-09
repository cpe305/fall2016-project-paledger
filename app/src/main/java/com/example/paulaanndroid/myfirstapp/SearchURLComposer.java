package com.example.paulaanndroid.myfirstapp;

/**
 * Created by Paula Ann on 10/26/2016.
 */

public class SearchURLComposer implements URLComposer {
    private URL url;
    private SearchParser parser;

    public SearchURLComposer() {
        url = new SkyMapURL("http://server1.sky-map.org/search?");
    }

    public SearchURLComposer(SearchParser newParser) {
        String urlString = "";


        url = new SkyMapURL();
    }

    public SearchURLComposer(String initURL, SearchParser newParser) {
        url = new SkyMapURL("http://server1.sky-map.org/search?");
    }


    public String compose() {
        return url.getURL();
    }
}
