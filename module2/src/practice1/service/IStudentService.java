package practice1.service;

import practice1.model.Student;

import java.io.IOException;
import java.util.List;

public interface IStudentService {
    void addStudent() throws IOException;

    void removeStudent() throws IOException;

    void displayAllStudents() throws IOException;

    void searchStudent() throws IOException;

    void sortStudent(List<Student> studentList) throws IOException;
}
