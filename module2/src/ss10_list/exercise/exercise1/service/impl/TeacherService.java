package ss10_list.exercise.exercise1.service.impl;

import ss10_list.exercise.exercise1.model.Teacher;
import ss10_list.exercise.exercise1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();
    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        System.out.println("Mời nhập mã Giáo Viên cần xoá: ");
        String id = sc.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(id)) {
                System.out.println("Bạn có chắc muốn xoá học sinh này không? Nhập Y để có,N để không.");
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
    public Teacher infoTeacher() {
        System.out.println("Mời bạn nhập mã Giáo Viên: ");
        String id = sc.nextLine();
        System.out.println("Mời bạn nhập tên Giáo Viên");
        String name = sc.nextLine();
        System.out.println("Mời bạn nhập ngày tháng năm sinh: ");
        String birthday = sc.nextLine();
        System.out.println("Mời bạn nhập vào giới tính: ");
        String tempSex = sc.nextLine();
        String gender;
        if (tempSex.equals("Nam")||tempSex.equals("nam")) {
            gender = "Nam";
        } else if (tempSex.equals("Nữ")||tempSex.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "không xác định";
        }
        System.out.println("Mời bạn nhập chuyên môn: ");
        String specialize = sc.nextLine();
        Teacher teacher = new Teacher(id, name, birthday, gender, specialize);
        return teacher;
    }
}
