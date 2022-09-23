package practice1.service;

import practice1.model.Student;

import java.util.List;

public interface IStudentService {
    void addStudent();

    void removeStudent();

    void displayAllStudents();

    void searchStudent();

    void sortStudent(List<Student> studentList);
}
