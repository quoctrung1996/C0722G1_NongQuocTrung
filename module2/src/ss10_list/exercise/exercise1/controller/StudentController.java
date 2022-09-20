package ss10_list.exercise.exercise1.controller;

import ss10_list.exercise.exercise1.service.IStudentService;
import ss10_list.exercise.exercise1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static IStudentService iStudentService = new StudentService();
    private static Scanner sc = new Scanner(System.in);

    public static void menuStudent() {
        while (true) {
            System.out.println("***Chào mừng đến với quản lý sinh viên***");
            System.out.println("Vui lòng chọn chức năng bạn cần: ");
            System.out.println("1. Thêm mới Sinh Viên");
            System.out.println("2. Hiển thị danh sách Sinh Viên");
            System.out.println("3. Xoá Sinh Viên");
            System.out.println("4. Quay về MENU chính");
            System.out.println("0. Thoát chương trình");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    iStudentService.addStudent();
                    break;
                case 2:
                    iStudentService.displayAllStudent();
                    break;
                case 3:
                    iStudentService.removeStudent();
                    break;
                case 4:
                    return;
                case 0:
                    System.exit(0);
            }
        }
    }
}