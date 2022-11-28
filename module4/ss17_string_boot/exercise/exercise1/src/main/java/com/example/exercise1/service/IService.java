package com.example.exercise1.service;

import java.util.Optional;

public interface IService<T>{
    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);
}
