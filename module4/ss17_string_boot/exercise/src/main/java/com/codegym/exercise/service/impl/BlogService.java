package com.codegym.exercise.service.impl;

import com.codegym.exercise.model.Blog;
import com.codegym.exercise.repository.IBlogRepository;
import com.codegym.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository ;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }
}
