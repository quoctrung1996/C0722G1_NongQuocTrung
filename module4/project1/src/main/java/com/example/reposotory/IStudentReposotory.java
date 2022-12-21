package com.example.reposotory;

import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentReposotory extends JpaRepository<Student,Integer> {
}
