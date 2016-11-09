package com.example.paulaanndroid.myfirstapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import android.util.Log;

import android.webkit.WebView;

public class LocationView extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        StarView {

    private GoogleApiClient client;
    private static final String TAG = "StarGazinActivity";
    private URLComposer urlComposer;
    private WebView webView;

    public LocationView() {
        urlComposer = new LocationURLComposer();
    }

    public void refresh() {}

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i(TAG, "Location services connected.");

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        client = new GoogleApiClient.Builder(this).addApi(LocationServices.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        client.disconnect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (client.isConnected()) {
            client.disconnect();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        client.connect();
    }
}
