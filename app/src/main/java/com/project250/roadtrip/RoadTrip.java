package com.project250.roadtrip;

import android.app.Application;
import com.firebase.client.Firebase;


public class RoadTrip extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
