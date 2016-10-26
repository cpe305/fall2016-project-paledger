/**
 * Created by Paula Ann on 10/26/2016.
 */

public class SkyMapURL extends URL {
    private String url;
    private String server;
    private StarID starID;
    private float zoomFactor;

    public SkyMapURL() {
        url = "";
    }

    public String getURL() {
        return url;
    }
}
