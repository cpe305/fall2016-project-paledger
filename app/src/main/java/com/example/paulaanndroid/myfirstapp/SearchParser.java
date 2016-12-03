package com.example.paulaanndroid.myfirstapp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

    public Document parseURL(String urlString) {
        try {
            DocumentBuilderFactory f =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document searchResult = b.parse(urlString);

            /*
            System.out.println ("Root element: " +
                    doc.getDocumentElement().getNodeName());

            // loop through each item
            NodeList items = doc.getDocumentElement().getElementsByTagName("constellation");
            for (int i = 0; i < items.getLength(); i++)
            {
                Node n = items.item(i);
                if (n.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                System.out.println(n.getNodeName() + " " + n.getTextContent());
            }*/
        } catch (Exception e) {
            System.out.println("XML Parsing Excpetion = " + e);
        }
        return searchResult;
    }

    public String getElement(String e) {
        if (searchResult != null) {
            return searchResult.getDocumentElement().getElementsByTagName(e).item(0).getTextContent();
        }
        return null;
    }
}