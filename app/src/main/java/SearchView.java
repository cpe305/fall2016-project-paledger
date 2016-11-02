/**
 * Created by Paula Ann on 10/26/2016.
 */

import android.webkit.WebView;

public class SearchView extends StarView {
    private URLComposer composer;
    private WebView view;

    public SearchView() {
        composer = new SearchURLComposer();
    }

    public void refresh() {

    }
}
