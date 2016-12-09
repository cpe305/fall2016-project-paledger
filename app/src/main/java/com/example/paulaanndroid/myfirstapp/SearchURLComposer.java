package com.example.paulaanndroid.myfirstapp;

import android.os.AsyncTask;

import org.w3c.dom.Document;

/**
 * Created by Paula Ann on 10/26/2016.
 */

public class SearchURLComposer implements URLComposer {
    private SkyMapURL url;
    private SearchParser parser;

    public SearchURLComposer() {
        System.out.println("BEGINNING???");
        url = new SkyMapURL("http://server1.sky-map.org/skywindow?");
        parser = new SearchParser();
    }

    public SearchURLComposer(SearchParser newParser) {
        parser = newParser;
        url = new SkyMapURL();
        initURLWithParser("http://server1.sky-map.org/skywindow?");
    }

    public SearchURLComposer(String initURL, SearchParser newParser) {
        parser = newParser;
        url = new SkyMapURL(initURL);
        initURLWithParser();
    }

    private boolean initURLWithParser(String baseUrl) {
        int initZoom = 6;

        url.setBaseURL(baseUrl);
        System.out.println("WHAT IS HAPPENING");
        System.out.println("RA: " + parser.getElement("ra"));
        String fragment = "";
        if ((fragment = parser.getElement("ra")) != null) {
            url.setRa(fragment);
        }
        if ((fragment = parser.getElement("de")) != null) {
            url.setDe(fragment);
        }
        url.setZoom(initZoom);
        System.out.println("In composer: " + parser.getElement("ra"));
        System.out.println("From URL: " + url.getRa());


        return true;
    }

    private boolean initURLWithParser() {
        System.out.println("in top initURLWithparser");
        System.out.println(url.getBaseURL());
        return initURLWithParser(url.getBaseURL());
    }

    public void refreshWithQuery(String query) {
        parser.parseQuery(query);
        initURLWithParser();
    }

    public String compose() {
        System.out.println("WHAT IS HAPPENING PART 3");
        return url.getURL();
    }


    public String compose(String query) {
        //new DownloadXMLResponse().execute(query);
        System.out.println("WHAT IS HAPPENING PART 2");
        parser.parseQuery(query);
        System.out.println("JUST PARSED, I'm composing");
        initURLWithParser();
        return url.getURL();
    }

    private class DownloadXMLResponse extends AsyncTask<String, Void, Document> {
        @Override
        protected Document doInBackground(String... queries) {
            return parser.parseQuery(queries[0]);
        }

        protected void onPostExectute(Document result) {
            System.out.println("Status: " + parser.getElement("status"));
            initURLWithParser();
        }
    }
}
