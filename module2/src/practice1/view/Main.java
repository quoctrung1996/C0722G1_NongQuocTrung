package practice1.view;

import practice1.controller.PersonController;
import practice1.service.impl.StudentService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        StudentService studentService=new StudentService();
//        studentService.displayAllStudents();
        PersonController.menuPerson();
    }
}
