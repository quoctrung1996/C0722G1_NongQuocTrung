package ss10_list.exercise.exercise1.service.impl;

import ss10_list.exercise.exercise1.model.Student;
import ss10_list.exercise.exercise1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới thành công! ");
    }

    @Override
    public void displayAllStudent() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        System.out.println("Mời bạn nhập mã Sinh Viên cần xoá: ");
        String id = sc.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(id)) {
                System.out.println("Bạn có chắc muốn xoá Sinh Viên?" +
                        "Nhập Y để xoá" +
                        "Nhập N để không xoá");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    studentList.remove(i);
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

    public Student infoStudent() {
        System.out.println("Mời bạn nhập mã Sinh Viên: ");
        String code = sc.nextLine();
        System.out.println("Mời bạn nhập tên Sinh Viên: ");
        String name = sc.nextLine();
        System.out.println("Mời bạn nhập năm ngày tháng năm sinh(dd/mm/yyyy): ");
        String birthday = sc.nextLine();
        System.out.println("Mời bạn nhập giới tính Sinh Viên");
        String tempSex = sc.nextLine();
        String gender;
        if (tempSex.equals("Nam")||tempSex.equals("nam")) {
            gender = "Nam";
        } else if (tempSex.equals("Nữ")||tempSex.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Không xác định";
        }
        System.out.println("Mời bạn nhập tên lớp: ");
        String nameClass = sc.nextLine();
        System.out.println("Mời bạn nhập điểm của Sinh Viên: ");
        double score = Double.parseDouble(sc.nextLine());
        Student student = new Student(code, name, birthday, gender, nameClass, score);
        return student;
    }
}
