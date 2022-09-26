package practice1.controller;

import practice1.model.Teacher;
import practice1.service.IStudentService;
import practice1.service.ITeacherService;
import practice1.service.impl.StudentService;
import practice1.service.impl.TeacherService;

import java.util.List;
import java.util.Scanner;

import static practice1.service.impl.StudentService.studentList;
import static practice1.service.impl.TeacherService.teacherList;

public class TeacherController {
    private static Scanner sc = new Scanner(System.in);
    private static ITeacherService iTeacherService = new TeacherService();

    public static void menuTeacher() {
        while (true) {
            System.out.println("----Chương trình quản lý giáo viên----");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1,Thêm mới giáo viên");
            System.out.println("2,Xóa giáo viên");
            System.out.println("3,Xem danh sách giáo viên");
            System.out.println("4,Tìm kiếm giáo viên");
            System.out.println("5,Sắp xếp giáo viên theo tên");
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
                    iTeacherService.addTeacher();
                    break;
                case 2:
                    iTeacherService.removeTeacher();
                    break;
                case 3:
                    iTeacherService.displayAllTeacher();
                    break;
                case 4:
                    iTeacherService.searchTeacher();
                    break;
                case 5:
                    iTeacherService.sortTeacher(teacherList);
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