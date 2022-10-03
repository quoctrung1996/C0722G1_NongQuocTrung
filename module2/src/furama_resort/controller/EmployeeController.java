package furama_resort.controller;

import furama_resort.service.IEmployeeService;
import furama_resort.service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner sc = new Scanner(System.in);
    private static IEmployeeService iEmployeeService = new EmployeeService();

    public static void employeeMenu() {

        while (true) {
            System.out.println("Quản lý Employees");
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employee");
            System.out.println("3.Edit employee");
            System.out.println("4.Return main menu");
            System.out.println("Xin mời chọn chức năng:");
            int choise = 0;
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
                    iEmployeeService.display();
                    break;
                case 2:
                    iEmployeeService.add();
                    break;
                case 3:
                    iEmployeeService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập sai,xin vui lòng nhập lại");
            }
        }
    }
}
