package com.example.prihann.androidroomexample.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseManager {
    private AppDatabase appDatabase;
    private static DatabaseManager databaseManager;

    private DatabaseManager(Context context) {
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "database-name").build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public static void init(Context context) {
        if (null == databaseManager)
            databaseManager = new DatabaseManager(context);
    }

    public static DatabaseManager getInstance() {
        return databaseManager;
    }

    public void close() {
        if (null != appDatabase)
            appDatabase.close();
    }
}
