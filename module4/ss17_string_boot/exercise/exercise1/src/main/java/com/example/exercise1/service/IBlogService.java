package com.example.exercise1.service;


import com.example.exercise1.model.Blog;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    List<Blog> findBlogByTitleContainingOrAuthorContainingOrderByTitle(String name);

}
