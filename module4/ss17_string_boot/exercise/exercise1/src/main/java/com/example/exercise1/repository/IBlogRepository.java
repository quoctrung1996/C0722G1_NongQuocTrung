package com.example.exercise1.repository;
import com.example.exercise1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findBlogByTitleContainingOrAuthorContainingOrderByTitle(String title,String author);
}
