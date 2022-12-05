package com.example.service.impl;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.IBlogRepository;
import com.example.repository.ICategoryRepository;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository ;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
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


    @Override
    public Page<Blog> findBlogByCategoryContaining(Pageable pageable, String name) {
        return iBlogRepository.findBlogByCategoryContaining(pageable,name);
    }

    @Override
    public Page<Blog> findByCategoryId(Pageable pageable, int id) {
        return iBlogRepository.findByCategoryId(pageable,id);
    }
}
