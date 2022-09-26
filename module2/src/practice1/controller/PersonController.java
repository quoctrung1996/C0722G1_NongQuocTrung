package practice1.controller;

import java.util.Scanner;

public class PersonController {
    public static Scanner sc = new Scanner(System.in);
//    public static StudentController studentController = new StudentController();
//    public static TeacherController teacherController = new TeacherController();
    
    public static void menuPerson() {
        while (true) {
            System.out.println("-------Chương trình quản lý học sing và giáo viên-------");
            System.out.println("Chọn chức năng theo số dể tiếp tục");
            System.out.println("1.Quản lý học sinh");
            System.out.println("2.Quản lý giáo viên");
            System.out.println("0.Kết thúc chương trình");
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
                    StudentController.menuStudent();
                    break;
                case 2:
                    TeacherController.menuTeacher();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhập không đúng,mời nhập lại");
            }
        }
    }
}

