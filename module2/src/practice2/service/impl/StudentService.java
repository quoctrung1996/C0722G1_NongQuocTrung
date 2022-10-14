package practice2.service.impl;

import practice2.model.Student;
import practice2.service.IStudentService;
import practice2.util.WriteFileAndReadFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent() {
        studentList= WriteFileAndReadFile.readFile();
        Student student = this.info();
        studentList.add(student);
        System.out.println("thêm thành công");
        WriteFileAndReadFile.writeFile(studentList);
    }

    @Override
    public void removeStudent() {
        System.out.println("Nhập mã số học sinh cần xóa");
        String code = sc.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            int choise;
            if (studentList.get(i).getCode().equals(code)) {
                while (true) {
                    System.out.println("Bạn có muốn xóa học sinh có mã " + studentList.get(i).getCode() + " không");
                    System.out.println("1.Có");
                    System.out.println("2.Không");
                    try {
                        choise = Integer.parseInt(sc.nextLine());
                        flagDelete = true;
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Nhập vào số");
                    }
                }
                switch (choise) {
                    case 1:
                        studentList.remove(i);
                        System.out.println("xóa thành công");
                        break;
                }
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy mã cần xóa");
        }
    }

    @Override
    public void displayStudent() {
        studentList= WriteFileAndReadFile.readFile();
        for (Student student:studentList){
            System.out.println(student.toString());
        }
        WriteFileAndReadFile.writeFile(studentList);
    }


    public Student info() {
        System.out.println("Nhập mã học sinh");
        String code = sc.nextLine();
        System.out.println("Nhập tên học sinh");
        String name = sc.nextLine();
        LocalDate dayOfBirth;
        while (true) {
            try {
                System.out.println("Nhập ngày sinh sinh viên(dd/MM/yyyy)");
                dayOfBirth = LocalDate.parse(sc.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("ngày sai định dạng,nhập lại!");
            }
        }
        String gender = null;
        boolean isChoise = false;
        while (!isChoise) {
            System.out.println("Nhập giới tính học sinh");
            System.out.println("1.Nam");
            System.out.println("2.Nữ");
            System.out.println("3.LJBT");
            int choise;
            while (true) {
                try {
                    choise = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Xin hãy nhập vào số");
                }
            }
            switch (choise) {
                case 1:
                    isChoise = true;
                    gender = "Nam";
                    break;
                case 2:
                    isChoise = true;
                    gender = "Nữ";
                    break;
                case 3:
                    isChoise = true;
                    gender = "LJBT";
                    break;
                default:
                    System.out.println("Nhập không đúng,mời nhập lại");
            }
        }
        System.out.println("Nhập tên lớp");
        String nameClass = sc.nextLine();
        double score;
        while (true) {
            System.out.println("Nhập điểm số học sinh");
            try {
                score = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập vào số");
            }
        }
        Student student = new Student(code, name, dayOfBirth, gender, nameClass, score);
        return student;
    }
}
