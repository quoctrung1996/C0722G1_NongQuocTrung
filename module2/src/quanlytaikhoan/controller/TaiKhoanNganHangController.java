package quanlytaikhoan.controller;

import quanlytaikhoan.service.ITaiKhoan;
import quanlytaikhoan.service.impl.TaiKhoanService;

import java.util.Scanner;

public class TaiKhoanNganHangController {
    Scanner sc = new Scanner(System.in);
    ITaiKhoan iTaiKhoan=new TaiKhoanService();

    public void quanLiTaiKhoan() {
        while (true) {
            System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN -----");
            System.out.println("Bấm số để chọn chức năng");
            System.out.println("1.Thêm mới\n2.Xóa\n3.Hiển thị danh sách\n4.Tìm kiếm\n5.Thoát");
            int choise;
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
                    themMoiTaiKhoan();
                    break;
                case 2:
                    iTaiKhoan.xoa();
                    break;
                case 3:
                    iTaiKhoan.hienThi();
                    break;
                case 4:
                    iTaiKhoan.timKiem();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Nhập không đúng,mời chọn lại");
            }

        }
    }

    public void themMoiTaiKhoan() {
        while (true) {
            System.out.println("1.Thêm mới tài khoản tiết kiệm");
            System.out.println("2.Thêm mới tài khoản thanh toán");
            System.out.println("3.Thoát");
            int choise;
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
                    iTaiKhoan.themMoiTaiKhoanTietKiem();
                    break;
                case 2:
                    iTaiKhoan.themMoiTaiKhoanThanhToan();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("xin mời nhập lại");
            }
        }
    }
}
