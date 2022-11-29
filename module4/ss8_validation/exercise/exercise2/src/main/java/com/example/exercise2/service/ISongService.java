package com.example.exercise2.service;


import com.example.exercise2.model.Song;

import java.util.Optional;


public interface ISongService {
    Iterable<Song> findAll();

    Optional<Song> findById(int id);

    void save(Song song);

    void remove(int id);
}
