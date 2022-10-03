package furama_resort.controller;

import furama_resort.service.IPromotionService;
import furama_resort.service.impl.PromotionService;

import java.util.Scanner;

public class PromotionController {
    private static Scanner sc = new Scanner(System.in);
    private static IPromotionService iPromotionService = new PromotionService();

    public static void promotionMenu() {
        while (true) {
            System.out.println("Quản lý Promotion ");
            System.out.println("1.Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3.Return main menu");
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
                    iPromotionService.displayService();
                    break;
                case 2:
                    iPromotionService.displayVoucher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập sai,xin vui lòng nhập lại");
            }
        }
    }
}
