package ss10_list.exercise.exercise1.controller;

import ss10_list.exercise.exercise1.service.ITeacherService;
import ss10_list.exercise.exercise1.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static ITeacherService iTeacherService = new TeacherService();
    private static Scanner sc = new Scanner(System.in);

    public static void menuTeacher() {
        while (true) {
            System.out.println("***Chào mừng bạn đến với quản lý Giáo Viên***");
            System.out.println("Vui lòng chọn chức năng bạn cần: ");
            System.out.println("1. Thêm Giáo Viên mới");
            System.out.println("2. Hiển thị danh sách Giáo Viên");
            System.out.println("3. Xoá Giáo Viên");
            System.out.println("4. Quay về MENU chính");
            System.out.println("0. Thoát chương trình");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    iTeacherService.addTeacher();
                    break;
                case 2:
                    iTeacherService.displayAllTeacher();
                    break;
                case 3:
                    iTeacherService.removeTeacher();
                case 4:
                    return;
                case 0:
                    System.exit(0);
            }
        }
    }
}