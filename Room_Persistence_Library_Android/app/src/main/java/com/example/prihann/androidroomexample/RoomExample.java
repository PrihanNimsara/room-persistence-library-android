package com.example.prihann.androidroomexample;

import android.app.Application;

import com.example.prihann.androidroomexample.database.DatabaseManager;

public class RoomExample extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
         DatabaseManager.getInstance().close();
    }
}
