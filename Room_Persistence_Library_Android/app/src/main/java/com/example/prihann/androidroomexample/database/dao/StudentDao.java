package com.example.prihann.androidroomexample.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.prihann.androidroomexample.model.Student;

import java.util.List;

@Dao
public interface StudentDao {
@Insert
    void insertStudentObject(Student student);
@Insert
    void insertStudentList(List<Student> studentList);
@Query("SELECT * FROM Student WHERE student_id = :studentId")
    Student getStudentUsingStudentId(Integer studentId);
@Update
    void updateStudent(Student student);
@Delete
    void deleteStudent(Student student);
}
