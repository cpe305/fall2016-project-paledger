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
        parser = newParser;

    }

    private boolean initURLWithParser() {
        if (parser.getElement("status") != null) {
            return false;
        }

        String urlString = "http://server1.sky-map.org/skywindow?";
        String fragment = "";
        if ((fragment = parser.getElement("object")) != null) {
            urlString += fragment;
            urlString += "&zoom=8";
        }
        return true;
    }

    public SearchURLComposer(String initURL, SearchParser newParser) {
        url = new SkyMapURL("http://server1.sky-map.org/search?");
    }


    public String compose() {
        return url.getURL();
    }
}
