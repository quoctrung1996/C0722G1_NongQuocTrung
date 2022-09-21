package ss12_tree_map.exercise.controller;

import ss12_tree_map.exercise.service.IProductService;
import ss12_tree_map.exercise.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    Scanner sc = new Scanner(System.in);
    IProductService iProductService = new ProductService();

    public void ProductMenu() {
        while (true) {
            System.out.println("----Chào mừng bạn đến với chương trình quản lý sản phẩm----");
            System.out.println("Nhập số để tiếp tục");
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Sửa thông tin sản phẩm");
            System.out.println("3.Xóa sản phẩm");
            System.out.println("4.Hiển thị danh sách");
            System.out.println("5.Tìm kiếm sản phẩm");
            System.out.println("6.Giá sản phẩm tăng dần hoặc giảm dần");
            System.out.println("0.Thoát chương trình");
            System.out.println("Xin mời chọn:");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    iProductService.addProduct();
                    break;
                case 2:
                    iProductService.editProduct();
                    break;
                case 3:
                    iProductService.deleteProduct();
                    break;
                case 4:
                    iProductService.displayProduct();
                    break;
                case 5:
                    iProductService.searchProduct();
                    break;
                case 6:
                    iProductService.upDownPrice();
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ,Xin vui lòng nhập lại");
            }
        }
    }
}
