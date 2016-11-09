package com.example.paulaanndroid.myfirstapp; /**
 * Created by Paula Ann on 10/26/2016.
 */
import java.lang.String;

public class SkyMapURL extends URL {
    private String url;

    //private com.example.paulaanndroid.myfirstapp.StarID starID;
    private String baseURL;
    private float zoomFactor;
    private String server;
    private String starID;
    private String ra;
    private String objStr;
    private String de;
    private String showBox;
    private String boxColor;
    private String boxWidth;
    private String boxHeight;
    private String zoom;
    private String showGrid;
    private String showConstellationLines;
    private String showConstellationBoundaries;
    private String imgSource;
    private boolean needsUpdate;

    public SkyMapURL(String baseURL) {
        this.baseURL = baseURL;
        url = baseURL;
        needsUpdate = true;
    }
    
    public void updateURL() {
        if (needsUpdate) {
            url = baseURL;
            if (objStr != null) {
                url += this.getObject();
            }
            if (ra != null) {
                url += this.getRa();
            }
            if (de != null) {
                url += this.getDe();
            }
            if (showBox != null) {
                url += this.getShowBox();
            }
            if (boxColor != null) {
                url += this.getBoxColor();
            }
            if (boxWidth != null) {
                url += this.getBoxWidth();
            }
            if (boxHeight != null) {
                url += this.getBoxHeight();
            }
            if (zoom != null) {
                url += this.getZoom();
            }
            if (showGrid != null) {
                url += this.getShowGrid();
            }
            if (showConstellationLines != null) {
                url += this.getShowConstellationLines();
            }
            if (showConstellationBoundaries != null) {
                url += this.getShowConstellationBoundaries();
            }
            if (imgSource != null) {
                url += this.getImgSource();
            }
            needsUpdate = false;
        }
    }

    public String getURL() {
        if (needsUpdate) {
            updateURL();
        }
        return url;
    }
    
    public void setRa(float ra) {
        needsUpdate = true;
        this.ra = String.valueOf(ra);   
    }
    
    public String getRa() {
        return "&ra=" + ra;
    }
    
    public void setObject(String objStr) {
        needsUpdate = true;
        this.objStr = objStr;   
    }
    
    public String getObject() {
        return "&object=" + objStr;
    }
    
    public void setDe(float de) {
        needsUpdate = true;
        this.de = String.valueOf(de);   
    }
    
    public String getDe() {
        return "&de=" + de;
    }
    
    public void setStarID(String starID) {
        needsUpdate = true;
        this.starID = starID;   
    }
    
    public String getStarID() {
        return "&star_id=" + starID;
    }
    
    public void setShowBox(int showBox) {
        needsUpdate = true;
        this.showBox = String.valueOf(showBox);   
    }
    
    public String getShowBox() {
        return "&show_box=" + showBox;
    }
    
    public void setBoxColor(String boxColor) {
        needsUpdate = true;
        this.boxColor = boxColor;   
    }
    
    public String getBoxColor() {
        return "&box_color=" + boxColor;
    }
    
    public void setBoxWidth(int boxWidth) {
        needsUpdate = true;
        this.boxWidth = String.valueOf(boxWidth);   
    }
    
    public String getBoxWidth() {
        return "&box_width=" + boxWidth;
    }
    
    public void setBoxHeight(int boxHeight) {
        needsUpdate = true;
        this.boxHeight = String.valueOf(boxHeight);   
    }
    
    public String getBoxHeight() {
        return "&box_height=" + boxHeight;
    }
    
    public void setZoom(float zoom) {
        needsUpdate = true;
        this.zoom = String.valueOf(zoom);   
    }
    
    public String getZoom() {
        return "&zoom=" + zoom;
    }
    
    public void setShowGrid(int showGrid) {
        needsUpdate = true;
        this.showGrid = String.valueOf(showGrid);   
    }
    
    public String getShowGrid() {
        return "&show_grid=" + showGrid;
    }
    
    public void setShowConstellationLines(int showConstellationLines) {
        needsUpdate = true;
        this.showConstellationLines = String.valueOf(showConstellationLines);   
    }
    
    public String getShowConstellationLines() {
        return "&show_constellation_lines=" + showConstellationLines;
    }
    
    public void setShowConstellationBoundaries(int showConstellationBoundaries) {
        needsUpdate = true;
        this.showConstellationBoundaries = String.valueOf(showConstellationBoundaries);   
    }
    
    public String getShowConstellationBoundaries() {
        return "&show_constellation_boundaries=" + showConstellationBoundaries;
    }
    
    public void setImgSource(String imgSource) {
        needsUpdate = true;
        this.imgSource = imgSource;   
    }
    
    public String getImgSource() {
        return "&img_source=" + imgSource;
    }

    public boolean getNeedsUpdate() {
        return needsUpdate;
    }
}
