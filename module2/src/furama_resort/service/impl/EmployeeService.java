package furama_resort.service.impl;

import furama_resort.model.Employee;
import furama_resort.service.IEmployeeService;
import furama_resort.utils.WriteAndRead;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    List<Employee> employeeList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        employeeList = WriteAndRead.readFile("src/furama_resort/data/employee.csv");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        WriteAndRead.writeFile(employeeList, "src/furama_resort/data/employee.csv");
    }

    @Override
    public void add() {
        employeeList = WriteAndRead.readFile("src/furama_resort/data/employee.csv");
        Employee employee = this.info();
        employeeList.add(employee);
        System.out.println("Thêm thành công");
        WriteAndRead.writeFile(employeeList, "src/furama_resort/data/employee.csv");

    }

    @Override
    public void edit() {
        employeeList = WriteAndRead.readFile("src/furama_resort/data/employee.csv");
        System.out.println("Nhập mã nhân viên cần sửa thông tin:");
        int id= Integer.parseInt(sc.nextLine());
        Employee employee;
        boolean isId=false;
        for (int i=0;i<employeeList.size();i++){
           if (employeeList.get(i).getId()==id){
               employeeList.remove(i);
               System.out.println("Nhập các thông tin mới:");
               employee=this.info();
               employeeList.add(i,employee);
               System.out.println("Sửa thành công");
               isId=true;
               break;
           }
        }
        if (!isId){
            System.out.println("Không tìm thấy mã nhân viên cần sửa");
        }

    }

    public Employee info() {
        System.out.println("Nhập mã nhân viên:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập họ tên nhân viên:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh nhân viên theo định dạng dd/MM/yyyy:");
        String birthday = sc.nextLine();
        System.out.println("Nhập giới tính nhân viên:");
        String gender = sc.nextLine();
        if (gender.equals("Nam") || gender.equals("nam")) {
            gender = "Nam";
        } else if (gender.equals("Nữ") || gender.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Không xác định";
        }
        System.out.println("Nhập CMND nhân viên:");
        String identityCard = sc.nextLine();
        System.out.println("Nhập số điện thoại nhân viên:");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập email nhân viên:");
        String email = sc.nextLine();
        System.out.println("Nhập trình độ nhân viên:");
        String level = sc.nextLine();
        System.out.println("Nhập vị trí của nhân viên:");
        String position = sc.nextLine();
        System.out.println("Nhập lương nhân viên:");
        double wage = Double.parseDouble(sc.nextLine());
        Employee employee = new Employee(id, name, birthday, gender, identityCard, phoneNumber, email, level, position, wage);
        return employee;
    }
}
