package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findBlogByCategoryContaining(Pageable pageable,String name);
    Page<Blog> findByCategoryId(Pageable pageable,int id);
}
