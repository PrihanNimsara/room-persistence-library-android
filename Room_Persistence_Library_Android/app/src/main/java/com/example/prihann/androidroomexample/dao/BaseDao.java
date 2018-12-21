package com.example.prihann.androidroomexample.dao;

import android.arch.persistence.room.Insert;

public interface BaseDao<T> {
    @Insert
    public void insert(T object);
}
