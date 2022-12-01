package com.example.student.service.impl;

import com.example.student.model.Student;
import com.example.student.reposotory.IStudentRepository;
import com.example.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public Optional<Student> findById(int id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        iStudentRepository.deleteById(id);
    }
}
