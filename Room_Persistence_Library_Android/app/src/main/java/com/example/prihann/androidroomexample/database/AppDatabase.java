package com.example.prihann.androidroomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.prihann.androidroomexample.database.dao.StudentDao;
import com.example.prihann.androidroomexample.model.Student;


@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
