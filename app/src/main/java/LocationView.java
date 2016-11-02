/**
 * Created by Paula Ann on 10/26/2016.
 */

import android.os.Bundle;
import android.webkit.WebView;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;

import com.example.paulaanndroid.myfirstapp.R;

public class LocationView extends StarView {
    private URLComposer composer;
    private WebView webView;
    private View view;

    public LocationView() {
        composer = new LocationURLComposer();
    }

    public void refresh(){

    }
}
