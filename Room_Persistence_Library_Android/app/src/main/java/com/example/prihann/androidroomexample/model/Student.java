package com.example.prihann.androidroomexample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    private Integer studentId;
    @ColumnInfo(name = "student_name")
    private String studentName;
    @ColumnInfo(name = "student_age")
    private Integer studentAge;
    @ColumnInfo(name = "student_country")
    private String studentCountry;

    @NonNull
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentCountry() {
        return studentCountry;
    }

    public void setStudentCountry(String studentCountry) {
        this.studentCountry = studentCountry;
    }
}
