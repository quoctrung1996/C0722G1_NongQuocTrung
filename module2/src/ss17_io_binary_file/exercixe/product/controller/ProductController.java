package ss17_io_binary_file.exercixe.product.controller;

import ss17_io_binary_file.exercixe.product.service.IproductService;
import ss17_io_binary_file.exercixe.product.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    public static Scanner sc = new Scanner(System.in);
    public static IproductService iproductService = new ProductService();

    public static void menu() {
        int choise;
        while (true) {
            while (true) {
                System.out.println("---Chào mừng bạn đến với chương trình quản lí sản phẩm---");
                System.out.println("Xin mời chọn chức năng:");
                System.out.println("1,Thêm sản phẩm");
                System.out.println("2,Hiển thị sản phẩm");
                System.out.println("3,Tìm kiếm sản phẩm theo tên");
                System.out.println("4,Tìm kiếm sản phẩm theo mã");
                System.out.println("0,Thoát chương trình");
                System.out.println("Xin mời chọn:");
                choise = Integer.parseInt(sc.nextLine());
                if (choise > 4 || choise < 0) {
                    System.out.println("Không có chức năng,xin mời chọn lại:");
                } else {
                    break;
                }
            }
            switch (choise) {
                case 1:
                    iproductService.addProduct();
                    break;
                case 2:
                    iproductService.displayProduct();
                    break;
                case 3:
                    iproductService.searchName();
                    break;
                case 4:
                    iproductService.searchId();
                    break;
                case 0:
                    System.exit(0);

            }
        }
    }
}