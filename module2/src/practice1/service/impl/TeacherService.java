package practice1.service.impl;

import practice1.model.Student;
import practice1.model.Teacher;
import practice1.service.ITeacherService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner sc = new Scanner(System.in);
    public static List<Teacher> teacherList = new ArrayList<>();

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

    @Override
    public void searchTeacher() {
        System.out.println("Bạn muốn tìm kiếm theo:");
        System.out.println("1.Tên giáo viên:");
        System.out.println("2.Mã giáo viên:");
        int choise = Integer.parseInt(sc.nextLine());
        switch (choise) {
            case 1:
                System.out.println("Nhập tên giáo viên:");
                String name = sc.nextLine();
                boolean isChoise = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getName().contains(name)) {
                        System.out.println(teacherList.get(i));
                        isChoise = true;
                    }
                }
                if (!isChoise) {
                    System.out.println("Không tìm thấy tên cần tìm");
                }
                break;
            case 2:
                System.out.println("Nhập mã giáo viên:");
                String code = sc.nextLine();
                boolean isChoise2 = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getCode().equals(code)) {
                        System.out.println(teacherList.get(i));
                        isChoise2 = true;
                        break;
                    }
                }
                if (!isChoise2) {
                    System.out.println("Không tìm thấy tên cần tìm");
                }
                break;
        }
    }

    @Override
    public void sortTeacher(List<Teacher> teacherList) {
        for (int i = 0; i < teacherList.size(); i++) {
            for (int j = 0; j < teacherList.size() - i - 1; j++) {
                int check = teacherList.get(j).getName().compareTo(teacherList.get(j + 1).getName());
                if (check > 0) {
                    Collections.swap(teacherList, j, j + 1);
                } else if (check == 0) {
                    if (teacherList.get(j).getCode().compareTo(teacherList.get(j + 1).getCode()) > 0) {
                        Collections.swap(teacherList, j, j + 1);
                    }
                } else {
                    System.out.println("Danh sách đã được sắp xếp");
                }
            }
        }
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
