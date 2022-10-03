package furama_resort.controller;

import furama_resort.service.ICustomerService;
import furama_resort.service.impl.CustomerService;
import java.util.Scanner;

public class CustomerController {
    private static Scanner sc = new Scanner(System.in);
    private static ICustomerService iCustomerService = new CustomerService();
    public static void customerMenu(){
        while (true) {
            System.out.println("Quản lý Customer");
            System.out.println("1.Display list customers");
            System.out.println("2.Add new customer");
            System.out.println("3.Edit customer");
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
                    iCustomerService.display();
                    break;
                case 2:
                    iCustomerService.add();
                    break;
                case 3:
                    iCustomerService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập sai,xin vui lòng nhập lại");
            }
        }
    }
}
