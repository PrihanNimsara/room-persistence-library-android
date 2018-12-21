package com.example.prihann.androidroomexample.repo;

import android.content.Context;
import android.os.AsyncTask;
import com.example.prihann.androidroomexample.database.AppDatabase;
import com.example.prihann.androidroomexample.model.Student;

import java.util.List;

public class StudentRepo implements Crud {

    private AppDatabase appDatabase;

    public StudentRepo(Context context) {
        this.appDatabase = AppDatabase.getAppDatabase(context);
    }

    @Override
    public int create(Object item) {
        SetUsersAsyncTask getUsersAsyncTask = new SetUsersAsyncTask((Student)item);
        getUsersAsyncTask.execute();
        return 0;
    }

    @Override
    public int update(Object item) {
        return 0;
    }

    @Override
    public int delete(Object item) {
        return 0;
    }

    @Override
    public List<Student> findAll() {
        try {
            return new GetUsersAsyncTask().execute().get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    private class SetUsersAsyncTask extends AsyncTask<Void, Void, Void> {

        Student student = null;

        public SetUsersAsyncTask(Student student) {
            this.student = student;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            appDatabase.studentDao().insertOnlySingleStudent(student);
            return null;
        }
    }

    private class GetUsersAsyncTask extends AsyncTask<Void, Void, List<Student>> {


        public GetUsersAsyncTask() {

        }


        @Override
        protected List<Student> doInBackground(Void... voids) {
            return appDatabase.studentDao().getAllStudents();
        }
    }
}
