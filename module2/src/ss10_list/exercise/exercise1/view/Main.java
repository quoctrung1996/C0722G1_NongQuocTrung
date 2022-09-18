package ss10_list.exercise.exercise1.view;

import ss10_list.exercise.exercise1.controller.PersonController;
import ss10_list.exercise.exercise1.controller.StudentController;
import ss10_list.exercise.exercise1.controller.TeacherController;

public class Main {
    public static void main(String[] args) {
        PersonController.menuPerson();
        StudentController.menuStudent();
        TeacherController.menuTeacher();
    }
}
