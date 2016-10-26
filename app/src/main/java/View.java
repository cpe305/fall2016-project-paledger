/**
 * Created by Paula Ann on 10/26/2016.
 */

import android.webkit.WebView;

public abstract class View {
    private URL url;
    private URLComposer composer;
    private WebView view;

    public abstract void refresh();
}
