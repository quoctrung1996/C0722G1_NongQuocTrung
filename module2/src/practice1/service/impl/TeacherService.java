package practice1.service.impl;

import practice1.model.Teacher;
import practice1.service.ITeacherService;
import ss10_list.exercise.exercise1.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void addTeacher() {
        Teacher teacher = this.inforTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm thành công");

    }

    @Override
    public void removeTeacher() {
        System.out.println("Mời bạn nhập mã giáo viên cần xoá: ");
        String id = sc.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(id)) {
                System.out.println("Bạn có chắc muốn xoá Giáo Viên?" +
                        "Nhập Y để xoá" +
                        "Nhập N để không xoá");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    teacherList.remove(i);
                    System.out.println("Xoá Thành Công!");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xoá.");
        }
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public Teacher inforTeacher() {
        System.out.println("Nhập mã giáo viên");
        String code = sc.nextLine();
        System.out.println("Nhập họ tên giáo viên");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh giáo viên(dd/mm/yyyy)");
        String birthday = sc.nextLine();
        System.out.println("Nhập giới tính giáo viên");
        String gender = sc.nextLine();
        if (gender.equals("Nam") || gender.equals("nam")) {
            gender = "Nam";
        } else if (gender.equals("Nữ") || gender.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Không xác định";
        }
        System.out.println("Nhập chuyên môn của giáo viên");
        String major = sc.nextLine();
        Teacher teacher = new Teacher(code, name, birthday, gender, major);
        return teacher;
    }
}
