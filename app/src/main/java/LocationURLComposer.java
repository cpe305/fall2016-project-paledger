/**
 * Created by Paula Ann on 10/26/2016.
 */

public class LocationURLComposer implements URLComposer {
    private URL url;

    public LocationURLComposer() {
        url = new SkyMapURL("http://server1.sky-map.org/skywindow?");
    }

    public String compose() {
        return url.getURL();
    }
}
