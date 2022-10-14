package practice2.controller;

import practice2.service.IStudentService;
import practice2.service.impl.StudentService;

import java.util.Scanner;

public class PersonController {
    Scanner sc = new Scanner(System.in);
    IStudentService iStudentService = new StudentService();

    public void menuPerson() {
        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH VÀ GIẢNG VIÊN--–-");
            System.out.println("1. CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH");
            System.out.println("2. CHƯƠNG TRÌNH QUẢN LÝ GIẢNG VIÊN");
            System.out.println("3. Thoát");
            System.out.println("Chọn chức năng:");
            int choise;
            while (true) {
                try {
                    choise = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Xin nhập vào số");
                }
            }
            switch (choise) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    menuTearcher();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không phù hợp,mời chọn lại");
            }
        }
    }

    public void menuStudent() {
        while (true) {
            int choise;
            while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH--–-");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Xóa học sinh");
            System.out.println("3. Xem danh sách học sinh");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức năng:");

                try {
                    choise = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Xin nhập vào số");
                }
            }
            switch (choise) {
                case 1:
                    iStudentService.addStudent();
                    break;
                case 2:
                    iStudentService.removeStudent();
                    break;
                case 3:
                    iStudentService.displayStudent();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Chọn không đúng,xin mời chọn lại");
            }
        }
    }

    public void menuTearcher() {

    }
}