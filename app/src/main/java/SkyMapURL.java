/**
 * Created by Paula Ann on 10/26/2016.
 */
import java.lang.String;

public class SkyMapURL extends URL {
    private String url;
    private String server;
    private StarID starID;
    private float zoomFactor;
    
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

    public SkyMapURL() {
        url = "";
    }
    
    public updateURL() {
        url = "http://server1.sky-map.org/skywindow.jsp?";
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
        if (showConstellationBoundaries != null){
            url += this.getShowConstellationBoundaries();
        }
        if (imgSource != null) {
            url += this.getImgSource();
        }
    }

    public String getURL() {
        return url;
    }
    
    public void setRa(float ra) {
        this.ra = String.valueOf(ra);   
    }
    
    public String getRa() {
        return "ra=" + ra;   
    }
    
    public void setObject(String objStr) {
        this.objStr = objStr;   
    }
    
    public String getObject() {
        return "object=" + objStr;   
    }
    
    public void setDe(float de) {
        this.de = String.valueOf(de);   
    }
    
    public String getDe() {
        return "de=" + de;   
    }
    
    public void setStarID(String starID) {
        this.starID = starID;   
    }
    
    public String getStarID() {
        return "star_id=" + starID;   
    }
    
    public void setShowBox(int showBox) {
        this.showBox = String.valueOf(showBox);   
    }
    
    public String getShowBox() {
        return "show_box=" + showBox;   
    }
    
    public void setBoxColor(String boxColor) {
        this.boxColor = boxColor;   
    }
    
    public String getBoxColor() {
        return "box_color=" + boxColor;   
    }
    
    public void setBoxWidth(int boxWidth) {
        this.boxWidth = String.valueOf(boxWidth);   
    }
    
    public String getBoxWidth() {
        return "box_width=" + boxWidth;   
    }
    
    public void setBoxHeight(int boxHeight) {
        this.boxHeight = String.valueOf(boxHeight);   
    }
    
    public String getBoxHeight() {
        return "box_height=" + boxHeight;   
    }
    
    public void setZoom(float zoom) {
        this.zoom = String.valueOf(zoom);   
    }
    
    public String getZoom() {
        return "zoom=" + zoom;   
    }
    
    public void setShowGrid(int showGrid) {
        this.showGrid = String.valueOf(showGrid);   
    }
    
    public String getShowGrid() {
        return "show_grid=" + showGrid;   
    }
    
    public void setShowConstellationLines(int showConstellationLines) {
        this.showConstellationLines = String.valueOf(showConstellationLines);   
    }
    
    public String getShowConstellationsLines() {
        return "show_constellation_lines=" + showConstellationLines;   
    }
    
    public void setShowConstellationBoundaries(int showConstellationBoundaries) {
        this.showConstellationBoundaries = String.valueOf(showConstellationBoundaries);   
    }
    
    public String getShowConstellationBoundaries() {
        return "show_constellation_boundaries=" + showConstellationBoundaries;   
    }
    
    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;   
    }
    
    public String getImgSource() {
        return "img_source=" + imgSource;   
    }
}
