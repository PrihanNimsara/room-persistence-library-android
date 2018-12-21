package com.example.prihann.androidroomexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.prihann.androidroomexample.R;
import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.model.Student;
import com.example.prihann.androidroomexample.repo.StudentRepo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);
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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readdata();
            }
        });
    }

    private void insertValues() {
        StudentRepo studentRepo = new StudentRepo(this);

        Student s = new Student();
        s.setStudentId("12");
        s.setStudentName("kama");
        s.setStudentAge(123);
        s.setStudentCountry("df");

        studentRepo.create(s);
    }


private void readdata(){
    List<Student> studentList = new StudentRepo(this).findAll();
    for(Student s: studentList)
        Log.d("padma","ddddddddddddddddddddddddddddddddd"+s.getStudentName());
}

}
