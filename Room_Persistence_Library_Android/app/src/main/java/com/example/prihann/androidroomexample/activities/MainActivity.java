package com.example.prihann.androidroomexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.prihann.androidroomexample.DatabaseInitializer;
import com.example.prihann.androidroomexample.R;
import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.model.Student;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                   insertValues();

                    }
                }).start();
            }
        });
    }

    private void insertValues() {
        DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this));
    }




}
