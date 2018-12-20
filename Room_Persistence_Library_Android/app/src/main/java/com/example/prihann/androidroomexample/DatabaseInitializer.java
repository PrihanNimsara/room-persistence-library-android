package com.example.prihann.androidroomexample;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.model.Student;

import java.util.List;

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Student addStudent(final AppDatabase db,Student user) {
        db.studentDao().insertAllStudent(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        Student student = new Student();
        student.setStudentId("100");
        student.setStudentName("Prihan");
        student.setStudentAge(22);
        student.setStudentCountry("Sri Lanka");
        addStudent(db, student);

        List<Student> studentList = db.studentDao().getAllStudents();
        Log.d(DatabaseInitializer.TAG, "Rows Count:........................ " + studentList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
