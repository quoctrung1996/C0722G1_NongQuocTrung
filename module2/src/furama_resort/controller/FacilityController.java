package furama_resort.controller;

import furama_resort.service.IFacilityService;
import furama_resort.service.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    private static Scanner sc = new Scanner(System.in);
    private static IFacilityService iFacilityService = new FacilityService();

    public static void facilityMenu() {
        while (true) {
            System.out.println("Quản lý Customer");
            System.out.println("1.Display list facility");
            System.out.println("2.Add new facility");
            System.out.println("3.Display list facility maintenance");
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
                    iFacilityService.displayFacility();
                    break;
                case 2:
                    iFacilityService.add();
                    break;
                case 3:
                    iFacilityService.displayFacilityMaintenance();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập sai,xin vui lòng nhập lại");
            }
        }
    }
}
