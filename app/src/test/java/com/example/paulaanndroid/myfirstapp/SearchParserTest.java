package com.example.paulaanndroid.myfirstapp;
import com.example.paulaanndroid.myfirstapp.SkyMapURL;

import org.junit.Test;
import org.w3c.dom.Document;

import static junit.framework.Assert.assertEquals;

/**
 * Basic tests for the com.example.paulaanndroid.myfirstapp.SearchParser class.
 * @author paulaledgerwood
 * @version November 29, 2016
 */
public class SearchParserTest {
    private static SearchParser parser = new SearchParser();

    @Test
    public void testParsing1() {
        String urlString = "polaris";
        Document doc = parser.parseQuery(urlString);
        assertEquals(doc.getElementsByTagName("constellation").item(0).getTextContent(), "Ursa Minor");
    }

    @Test
    public void testParsingGetElement1() {
        String urlString = "polaris";
        parser.parseQuery(urlString);
        assertEquals(parser.getElement("constellation"), "Ursa Minor");
    }

    @Test
    public void testParsingGetElement2() {
        String urlString = "orion";
        parser.parseQuery(urlString);
        assertEquals(parser.getElement("ra"), "5.5765426");
    }
}