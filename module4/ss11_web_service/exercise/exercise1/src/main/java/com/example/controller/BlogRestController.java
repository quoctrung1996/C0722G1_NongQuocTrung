package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("blogs")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<Page<Blog>> getList(@PageableDefault(page = 0, size = 2) Pageable pageable) {
        Page<Blog> blogList = iBlogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blog.setCategory(iCategoryService.findById(blog.getCategory().getId()).get());
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id) {
        Blog blog = iBlogService.findById(id).get();

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Page<Blog>> showList(@PathVariable int id, @PageableDefault(page = 0, size = 2) Pageable pageable) {
        Page<Blog> blogList = iBlogService.findByCategoryId(pageable, id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

}
