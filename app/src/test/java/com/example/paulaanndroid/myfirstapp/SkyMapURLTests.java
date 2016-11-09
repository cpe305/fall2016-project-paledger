package com.example.paulaanndroid.myfirstapp;
import com.example.paulaanndroid.myfirstapp.SkyMapURL;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Basic tests for the com.example.paulaanndroid.myfirstapp.SkyMapURL class.
 * @author sarahpadlipsky
 * @version November 2, 2016
 */
public class SkyMapURLTests {

  @Test
  public void testConstructor() {
    String urlString = "testing";
    SkyMapURL url = new SkyMapURL(urlString);
    assertEquals(urlString, url.getURL());
    assertEquals(true, url.getNeedsUpdate());
  }

  @Test
  public void testObjRaDe() {
    String urlString = "testing";
    SkyMapURL url = new SkyMapURL(urlString);
    url.setObject("objectString");
    urlString += url.getObject();
    url.setRa(2);
    urlString += url.getRa();
    url.setDe(3);
    urlString += url.getDe();
    url.updateURL();
    assertEquals(urlString, url.getURL());
  }

  @Test
  public void testBoxInfo() {
    String urlString = "testing";
    SkyMapURL url = new SkyMapURL(urlString);
    url.setShowBox(5);
    urlString += url.getShowBox();
    url.setBoxColor("blue");
    urlString += url.getBoxColor();
    url.setBoxWidth(4);
    urlString += url.getBoxWidth();
    url.setBoxHeight(10);
    urlString += url.getBoxHeight();
    url.updateURL();
    assertEquals(urlString, url.getURL());
  }

  @Test
  public void testRestOfInfo() {
    String urlString = "testing";
    SkyMapURL url = new SkyMapURL(urlString);
    url.setZoom(3);
    urlString += url.getZoom();
    url.setShowGrid(4);
    urlString += url.getShowGrid();
    url.setShowConstellationLines(1);
    urlString += url.getShowConstellationLines();
    url.setShowConstellationBoundaries(0);
    urlString += url.getShowConstellationBoundaries();
    url.setImgSource("imgSource");
    urlString += url.getImgSource();
    url.updateURL();

    assertEquals(urlString, url.getURL());
  }
}