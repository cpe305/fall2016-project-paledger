package com.example.paulaanndroid.myfirstapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.DropBoxManager;
import android.util.Log;
import android.util.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.IOException.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Paula Ann on 11/29/2016.
 */

public class SearchParser {
    private static Document searchResult;

    public SearchParser() {
        searchResult = null;
    }

    public Document parseQuery(String query) {
        String urlString = "http://server1.sky-map.org/search?star=" + query;
        System.out.println(urlString);

        searchResult = parseURL(urlString);
        System.out.println("just parsed query");
        //new DownloadXMLResponse().execute(urlString);
        System.out.println("GETTING RAA" + getElement("ra"));

        return searchResult;
        //return parseURL(urlString);
    }

    private Document parseURL(String urlString) {
        try {
            DocumentBuilderFactory f =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            searchResult = b.parse(urlString);
            System.out.println("Status: " + getElement("status"));
            if (getElement("status").equals("0")) {
                System.out.println("VALID");
                return searchResult;
            }
            else {
                searchResult = null;
            }
        } catch (Exception e) {
            System.out.println("XML Parsing Exception = " + e);
        }
        return searchResult;
    }

    private InputStream getUrlData(String urlString) throws URISyntaxException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return in;
        } finally {
            urlConnection.disconnect();
        }
    }


    public String getElement(String e) {
        if (searchResult != null &&
                searchResult.getDocumentElement().getElementsByTagName(e).item(0) != null) {
            return searchResult.getDocumentElement().getElementsByTagName(e).item(0).getTextContent();
        }
        return null;
    }


    private class DownloadXMLResponse extends AsyncTask<String, Void, Document> {
        @Override
        protected Document doInBackground(String... urls) {
            return parseURL(urls[0]);
        }

        protected void onPostExectute(Document result) {
            searchResult = result;
        }

    }
}