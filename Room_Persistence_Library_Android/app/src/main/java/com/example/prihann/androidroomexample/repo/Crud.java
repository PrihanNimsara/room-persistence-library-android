package com.example.prihann.androidroomexample.repo;

import java.util.List;

public interface Crud {
    int create(Object item);
    int update(Object item);
    int delete(Object item);
    List<?> findAll();
}
