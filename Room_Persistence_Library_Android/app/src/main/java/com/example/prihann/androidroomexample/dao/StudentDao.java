package com.example.prihann.androidroomexample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.example.prihann.androidroomexample.model.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM student where student_id LIKE  :studentId")
    Student findStudentByUsingStudentId(String studentId);

    @Query("SELECT COUNT(*) from student")
    int countStudents();

    @Insert
    void insertMultipleStudent(Student... students);

    @Insert
    void insertMultipleListStudent(List<Student> studentList);

    @Transaction
    @Insert
    void insertOnlySingleStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);

}
