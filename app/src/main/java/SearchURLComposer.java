/**
 * Created by Paula Ann on 10/26/2016.
 */

public class SearchURLComposer implements URLComposer {
    private URL url;

    public SearchURLComposer() {

    }

    public String compose() {
        return url.getURL();
    }
}
