package furama_resort.controller;

import furama_resort.service.IBookingService;
import furama_resort.service.impl.BookingService;

import java.util.Scanner;

public class BookingController {
    private static Scanner sc = new Scanner(System.in);
    private static IBookingService iBookingService=new BookingService();
    public static void bookingMenu(){
        while (true) {
            System.out.println("Quản lý Customer");
            System.out.println("1.Add new booking");
            System.out.println("2.Display list booking");
            System.out.println("3.Create new constracts");
            System.out.println("4.Display list contracts");
            System.out.println("5.Edit contracts");
            System.out.println("6.Return main menu");
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
                    iBookingService.add();
                    break;
                case 2:
                    iBookingService.displayListBooking();
                    break;
                case 3:
                    iBookingService.createNewConstracts();
                    break;
                case 4:
                    iBookingService.displayListContracts();
                    break;
                case 5:
                    iBookingService.editContracts();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Nhập sai,xin vui lòng nhập lại");
            }
        }
    }
}
