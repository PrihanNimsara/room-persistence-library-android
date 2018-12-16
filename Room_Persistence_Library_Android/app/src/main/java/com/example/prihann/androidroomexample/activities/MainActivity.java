package com.example.prihann.androidroomexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.prihann.androidroomexample.R;
import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.database.DatabaseManager;
import com.example.prihann.androidroomexample.model.Student;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = DatabaseManager.getInstance().getAppDatabase();

        new Thread(new Runnable() {
            @Override
            public void run() {
                insertValues();


            }
        }).start();


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getData();


                    }
                }).start();
            }
        });
    }

    private void insertValues() {
        Student student = new Student();
        student.setStudentName("Prihan");
        student.setStudentAge(22);
        student.setStudentCountry("Sri Lanka");
        appDatabase.studentDao().insertStudentObject(student);
    }


    private void getData() {
        Student student = appDatabase.studentDao().getStudentUsingStudentId(1);
        Log.d("log", student.getStudentName());
    }

}
