package practice1.service.impl;

import practice1.model.Student;
import practice1.service.IStudentService;
import practice1.util.StudentException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner sc = new Scanner(System.in);
    public static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = this.inforStudent();
        studentList.add(student);
        System.out.println("Thêm thành công");
    }

    @Override
    public void removeStudent() {
        System.out.println("Mời bạn nhập mã sinh viên cần xóa:");
        String code = sc.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc chắn muốn xóa?\n Nhập Y để xóa\n Nhập N để không xóa");
                String choise = sc.nextLine();
                if (choise.equals("Y")) {
                    studentList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        }
    }

    @Override
    public void displayAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void searchStudent() {
        System.out.println("Bạn muốn tìm kiếm theo:");
        System.out.println("1.Tên học sinh:");
        System.out.println("2.Mã học sinh:");
        int choise = 0;
        while (true) {
            try {
                choise = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Xin hãy nhập số");
            }
        }
        switch (choise) {
            case 1:
                System.out.println("Nhập tên học sinh");
                String name = sc.nextLine();
                boolean isChoise = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getName().contains(name)) {
                        System.out.println(studentList.get(i));
                        isChoise = true;
                    }
                }
                if (!isChoise) {
                    System.out.println("Không tìm thấy tên cần tìm");
                }
                break;
            case 2:
                System.out.println("Nhập mã học sinh");
                String code = sc.nextLine();
                boolean isChoise2 = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getCode().equals(code)) {
                        System.out.println(studentList.get(i));
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
    public void sortStudent(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < studentList.size() - i - 1; j++) {
                int check = studentList.get(j).getName().compareTo(studentList.get(j + 1).getName());
                if (check > 0) {
//                    Student temp = studentList.get(j+1);
//                    studentList.set(j + 1, studentList.get(j));
//                    studentList.set(j,temp);
                    Collections.swap(studentList, j, j + 1);
                } else if (check == 0) {
                    if (studentList.get(j).getCode().compareTo(studentList.get(j + 1).getCode()) > 0) {
                        Collections.swap(studentList, j, j + 1);
                    }
                } else {
                    System.out.println("Danh sách đã được sắp xếp");
                }
            }
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

//        Collections.sort(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if (!o1.getName().equals(o2.getName())) {
//                    return o1.getName().compareTo(o2.getName());
//                }
//                return o1.getCode().compareTo(o2.getCode());
//            }
//        });

    public Student inforStudent() {
        System.out.println("Nhập mã sinh viên");
        String code = sc.nextLine();
        String name;
        while (true) {
            try {
                System.out.println("Nhập họ tên sinh viên");
                name = sc.nextLine();
                checkName(name);
                break;
            } catch (StudentException e) {
                System.out.println(e.getMessage());
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday;
        while (true) {
            try {
                System.out.println("Nhập ngày sinh sinh viên(dd/MM/yyyy)");
                birthday = LocalDate.parse(sc.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("ngày sai định dạng,nhập lại!");
            }
        }
        System.out.println("Nhập giới tính sinh viên");
        String gender = sc.nextLine();
        if (gender.equals("Nam") || gender.equals("nam")) {
            gender = "Nam";
        } else if (gender.equals("Nữ") || gender.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Không xác định";
        }
        System.out.println("Nhập lớp của sinh viên");
        String className = sc.nextLine();
        double score;
        while (true) {
            try {
                System.out.println("Nhập điểm số sinh viên");
                score = Double.parseDouble(sc.nextLine());
                checkScore(score);
                break;
            } catch (StudentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Điểm không được chứa kí tự");
            }

        }
        Student student = new Student(code, name, birthday, gender, className, score);
        return student;
    }

    public void checkName(String s) throws StudentException {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                throw new StudentException("Tên không được chứa số và kí tự đặc biệt,xin nhập lại");
            }
        }
    }

    public void checkScore(double score) throws StudentException {
        if (score > 10 || score < 0) {
            throw new StudentException("Điểm không được nhỏ hơn 0 và lớn hơn 10,xin nhập lại");
        }
    }
}
