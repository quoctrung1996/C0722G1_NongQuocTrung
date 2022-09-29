package practice1.controller;

import practice1.service.IStudentService;
import practice1.service.impl.StudentService;

import java.io.IOException;
import java.util.Scanner;

import static practice1.service.impl.StudentService.studentList;

public class StudentController {
    private static Scanner sc = new Scanner(System.in);
    private static IStudentService iStudentService = new StudentService();

    public static void menuStudent() throws IOException {
        while (true) {
            System.out.println("----Chương trình quản lý học sinh----");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1,Thêm mới học sinh");
            System.out.println("2,Xóa học sinh");
            System.out.println("3,Xem danh sách học sinh");
            System.out.println("4,Tìm kiếm học sinh");
            System.out.println("5,Sắp xếp học sinh theo tên");
            System.out.println("6,Quay về menu chính");
            System.out.println("0,Thoát chương trình");
            System.out.println("Chọn chức năng");
            int choise = 0;
            while (true) {
                try {
                    choise = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Xin hãy nhập vào số");
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
                    iStudentService.displayAllStudents();
                    break;
                case 4:
                    iStudentService.searchStudent();
                    break;
                case 5:
                    iStudentService.sortStudent(studentList);
                    break;
                case 6:
                    return;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhập không đúng,mời nhập lại");
            }
        }
    }
}
