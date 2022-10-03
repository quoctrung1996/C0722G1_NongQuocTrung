package furama_resort.controller;

import java.util.Scanner;

public class FuramaController {

    private static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
        System.out.println("----Chào mừng bạn đến với ứng dụng quản lý khu nghỉ dưỡng Furama----");
        System.out.println("1.Employee Management");
        System.out.println("2.Customer Management");
        System.out.println("3.Facility Management ");
        System.out.println("4.Booking Management");
        System.out.println("5.Promotion Management");
        System.out.println("6.Exit");
        System.out.println("Xin mời chọn:");
        int choise =0;
        while (true){
            try {
                choise= Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Xin hãy nhập vào số");
            }
        }
            switch (choise) {
                case 1:
                    EmployeeController.employeeMenu();
                    break;
                case 2:
                    CustomerController.customerMenu();
                    break;
                case 3:
                    FacilityController.facilityMenu();
                    break;
                case 4:
                    BookingController.bookingMenu();
                    break;
                case 5:
                    PromotionController.promotionMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Nhập sai,xin vui lòng nhập lại");
            }
        }
    }
}
