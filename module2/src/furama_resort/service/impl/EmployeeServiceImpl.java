package furama_resort.service.impl;

import furama_resort.model.Employee;
import furama_resort.service.IEmployeeService;
import furama_resort.utils.checks.Check;
import furama_resort.utils.checks.CheckException;
import furama_resort.utils.checks.CheckRegexFacility;
import furama_resort.utils.write_and_read.ReadFile;
import furama_resort.utils.write_and_read.WriteFile;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final String REGEX_FILE = "src/furama_resort/data/employee.csv";
    List<Employee> employeeList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    CheckRegexFacility checkRegexFacility = new CheckRegexFacility();
    CheckException checkException=new CheckException();


    @Override
    public void display() {
        employeeList = ReadFile.readFileEmployee(REGEX_FILE);
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        WriteFile.writeFileEmployee(employeeList, REGEX_FILE);
    }

    @Override
    public void add() {
        employeeList = ReadFile.readFileEmployee(REGEX_FILE);
        Employee employee = this.info();
        employeeList.add(employee);
        WriteFile.writeFileEmployee(employeeList, REGEX_FILE);
        System.out.println("Thêm thành công");

    }

    @Override
    public void edit() {
        employeeList = ReadFile.readFileEmployee(REGEX_FILE);
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần sửa thông tin:");
                id = Integer.parseInt(sc.nextLine());
                checkException.checkNumber(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Xin hãy nhập số:");
            }catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        Employee employee;
        boolean isId = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(i);
                System.out.println("Nhập các thông tin mới:");
                employee = this.info();
                employeeList.add(i, employee);
                System.out.println("Sửa thành công");
                isId = true;
                break;
            }
        }
        if (!isId) {
            System.out.println("Không tìm thấy mã nhân viên cần sửa");
        }
        WriteFile.writeFileEmployee(employeeList, REGEX_FILE);

    }

    public Employee info() {
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã số nhân viên :");
                id = Integer.parseInt(sc.nextLine());
                checkException.checkNumber(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Xin hãy nhập số:");
            }catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            System.out.println("Nhập họ tên nhân viên:");
            name = sc.nextLine();
            if (!checkRegexFacility.checkName(name)) {
                System.out.println("Nhập tên sai định dạng,xin nhập lại:");
            } else {
                break;
            }
        }

        LocalDate birthday;
        while (true) {
            System.out.println("Nhập ngày sinh khách hàng theo định dạng dd/MM/yyyy:");
            try {
                birthday = LocalDate.parse(sc.nextLine(), formatter);
                LocalDate date = LocalDate.now();
                Period checkAge = Period.between(birthday, date);
                if (checkAge.getYears() < 18 || checkAge.getYears() > 100) {
                    throw new DateTimeException("Tuổi phải nằm trong khoảng từ 18-100");
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày sinh sai định dạng ,xin nhập lại:");
            } catch (DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
        String gender = "";
        boolean isChoise = false;
        while (!isChoise) {
            System.out.println("Nhập giới tính nhân viên:");
            System.out.println("1.Nam");
            System.out.println("2.Nữ");
            System.out.println("3.LJBT");
            try {
                int choise = Integer.parseInt(sc.nextLine());
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
                        System.out.println("Nhập không đúng,vui lòng nhập lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Xin hãy nhập vào số");
            }
        }
        String identityCard;
        while (true) {
            System.out.println("Nhập CMND nhân viên 9 hoặc 12 số:");
            identityCard = sc.nextLine();
            if (!checkRegexFacility.checkIdentityCard(identityCard)) {
                System.out.println("Nhập sai định dạng,xin nhập lại:");
            } else {
                break;
            }
        }
        String phoneNumber;
        while (true) {
            System.out.println("Nhập số điện thoại nhân viên +84XXXXXXXXX");
            phoneNumber = sc.nextLine();
            if (!checkRegexFacility.checkPhoneNumber(phoneNumber)) {
                System.out.println("Nhập số điện thoại sai định dạng,xin nhập lại:");
            } else {
                break;
            }
        }
        String email;
        while (true) {
            System.out.println("Nhập email nhân viên:");
            email = sc.nextLine();
            if (!checkRegexFacility.checkEmail(email)) {
                System.out.println("Nhập email không hợp lệ,xin nhập lại:");
            } else {
                break;
            }
        }

        String level = "";
        isChoise = false;
        while (!isChoise) {
            System.out.println("Chọn trình độ nhân viên:");
            System.out.println("1.Trung cấp");
            System.out.println("2.Cao đẳng");
            System.out.println("3.Đại học");
            System.out.println("4.Sau đại học");
            System.out.println("Mời chọn số");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise) {
                    case 1:
                        isChoise = true;
                        level = "Trung cấp";
                        break;
                    case 2:
                        isChoise = true;
                        level = "Cao đẳng";
                        break;
                    case 3:
                        isChoise = true;
                        level = "Đại học";
                        break;
                    case 4:
                        isChoise = true;
                        level = "Sau đại học";
                        break;
                    default:
                        System.out.println("Mời chọn lại:");
                }
            }catch (NumberFormatException e){
                System.out.println("Hãy nhập vào số");
            }
        }
        String position = "";
        isChoise=false;
        while (!isChoise) {
            System.out.println("Chọn vị trí của nhân viên:");
            System.out.println("1.Lễ tân");
            System.out.println("2.Phục vụ");
            System.out.println("3.Chuyên viên");
            System.out.println("4.Giám sát");
            System.out.println("5.Quản lý");
            System.out.println("6.Giám đốc");
            System.out.println("Mời chọn số:");
            try {
                int choise = Integer.parseInt(sc.nextLine());
                switch (choise) {
                    case 1:
                        isChoise=true;
                        position = "Lễ tân";
                        break;
                    case 2:
                        isChoise=true;
                        position = "Phục vụ";
                        break;
                    case 3:
                        isChoise=true;
                        position = "Chuyên viên";
                        break;
                    case 4:
                        isChoise=true;
                        position = "Giám sát";
                        break;
                    case 5:
                        isChoise=true;
                        position = "Quản lý";
                        break;
                    case 6:
                        isChoise=true;
                        position = "Giám đốc";
                        break;
                    default:
                        System.out.println("Mời chọn lại:");
                }
            }catch (NumberFormatException e){
                System.out.println("Hãy nhập vào số");
            }
        }
        double wage;
        while (true) {
            try {
                System.out.println("Nhập lương nhân viên:");
                wage = Double.parseDouble(sc.nextLine());
                checkException.checkWage(wage);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Hãy nhập vào số");
            }
        }
        Employee employee = new Employee(id, name, birthday, gender, identityCard, phoneNumber, email, level, position, wage);
        return employee;
    }
}
