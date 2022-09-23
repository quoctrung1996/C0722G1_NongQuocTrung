package practice1.service;

import practice1.model.Teacher;

import java.util.List;

public interface ITeacherService {
    void addTeacher();

    void removeTeacher();

    void displayAllTeacher();

    void searchTeacher();

    void sortTeacher(List<Teacher> teacherList);
}
