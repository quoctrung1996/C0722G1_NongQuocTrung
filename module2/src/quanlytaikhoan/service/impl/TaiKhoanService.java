package quanlytaikhoan.service.impl;

import quanlytaikhoan.model.TaiKhoanNganHang;
import quanlytaikhoan.model.TaiKhoanThanhToan;
import quanlytaikhoan.model.TaiKhoanTietKiem;
import quanlytaikhoan.service.ITaiKhoan;
import quanlytaikhoan.util.checks.Check;
import quanlytaikhoan.util.checks.CheckException;
import quanlytaikhoan.util.checks.CheckRegex;
import quanlytaikhoan.util.read_and_write.DocGhiFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanService implements ITaiKhoan {
    List<TaiKhoanNganHang> taiKhoanNganHangList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    public void themMoiTaiKhoanTietKiem() {
        taiKhoanNganHangList = DocGhiFile.docFile();
        TaiKhoanTietKiem taiKhoanTietKiem = this.thongTinTaiKhoanTietKiem();
        taiKhoanNganHangList.add(taiKhoanTietKiem);
        DocGhiFile.ghiFile(taiKhoanNganHangList);
        System.out.println("Thêm thành công");
    }

    @Override
    public void themMoiTaiKhoanThanhToan() {
        taiKhoanNganHangList = DocGhiFile.docFile();
        TaiKhoanThanhToan taiKhoanThanhToan = this.thongTinTaiKhoanThanhToan();
        taiKhoanNganHangList.add(taiKhoanThanhToan);
        DocGhiFile.ghiFile(taiKhoanNganHangList);
        System.out.println("Thêm thành công");
    }

    @Override
    public void hienThi() {
        taiKhoanNganHangList = DocGhiFile.docFile();
        for (TaiKhoanNganHang taiKhoanNganHang : taiKhoanNganHangList) {
            System.out.println(taiKhoanNganHang.toString());
        }
        DocGhiFile.ghiFile(taiKhoanNganHangList);
    }

    @Override
    public void xoa() {
        taiKhoanNganHangList = DocGhiFile.docFile();
        System.out.println("Nhập mã tài khoản cần xóa");
        int ma;
        while (true) {
            try {
                ma = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(ma);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        boolean isChoise = false;
        for (int i = 0; i < taiKhoanNganHangList.size(); i++) {
            if (taiKhoanNganHangList.get(i).getMa() == ma) {
                isChoise = true;
                System.out.println("Bạn có muốn xóa không,nhấn:\nY:Có\nN:Không");
                String choise = sc.nextLine();
                if (choise.equals("Y")) {
                    taiKhoanNganHangList.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
        }
        if (!isChoise) {
            System.out.println("Không tìm thấy mã cần xóa");
        }
        for (TaiKhoanNganHang taiKhoanNganHang : taiKhoanNganHangList) {
            System.out.println(taiKhoanNganHang.toString());
        }
        DocGhiFile.ghiFile(taiKhoanNganHangList);

    }

    @Override
    public void timKiem() {
        taiKhoanNganHangList = DocGhiFile.docFile();
        System.out.println("Bạn muốn tìm kiếm theo\n1.mã tài khoản\n2.tên chủ tài khoản");
        int choise;
        while (true) {
            try {
                choise = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(choise);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        boolean isChoise = false;
        switch (choise) {
            case 1:
                isChoise = false;
                System.out.println("Nhập mã tài khoản");
                int ma;
                while (true) {
                    try {
                        ma = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Mời nhập số");
                    }
                }
                for (int i = 0; i < taiKhoanNganHangList.size(); i++) {
                    if (taiKhoanNganHangList.get(i).getMa() == ma) {
                        System.out.println(taiKhoanNganHangList.get(i).toString());
                        isChoise = true;
                        break;
                    }
                }
                if (!isChoise) {
                    System.out.println("mã tài khoản không đúng");
                }
                break;
            case 2:
                isChoise = false;
                System.out.println("Nhập tên chủ tài khoản gần đúng");
                String ten = sc.nextLine();
                for (int i = 0; i < taiKhoanNganHangList.size(); i++) {
                    if (taiKhoanNganHangList.get(i).getTen().contains(ten)) {
                        System.out.println(taiKhoanNganHangList.get(i).toString());
                        isChoise = true;
                        break;
                    }
                }
                if (!isChoise) {
                    System.out.println("tên chủ tài khoản không đúng");
                }
                break;
            default:
                System.out.println("xin mời chọn lại");
        }
        DocGhiFile.ghiFile(taiKhoanNganHangList);
    }


    public TaiKhoanThanhToan thongTinTaiKhoanThanhToan() {
        int id = taiKhoanNganHangList.get(taiKhoanNganHangList.size() - 1).getId() + 1;
        System.out.println("Nhập mã tài khoản");
        int ma;
        while (true) {
            try {
                ma = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(ma);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập tên chủ tài khoản");
        String ten;
        while (true) {
            ten = sc.nextLine();
            if (!CheckRegex.checkTen(ten)) {
                System.out.println("Nhập lại tên ");
            } else {
                break;
            }
        }
        System.out.println("Nhập ngày tạo tài khoản");
        LocalDate ngayTao;
        while (true){
            try {
                ngayTao = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Nhập ngày sai định dạng");
            }
        }

        System.out.println("Nhập số thẻ");
        String soThe = sc.nextLine();
        System.out.println("Nhập số tiền");
        int soTien;
        while (true) {
            try {
                soTien = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(soTien);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(id, ma, ten, ngayTao, soThe, soTien);
        return taiKhoanThanhToan;
    }


    public TaiKhoanTietKiem thongTinTaiKhoanTietKiem() {
        int id = taiKhoanNganHangList.size() + 1;
        System.out.println("Nhập mã tài khoản");
        int ma;
        while (true) {
            try {
                ma = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(ma);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập tên chủ tài khoản");
        String ten;
        while (true) {
            ten = sc.nextLine();
            if (!CheckRegex.checkTen(ten)) {
                System.out.println("Nhập lại tên");
            } else {
                break;
            }
        }
        System.out.println("Nhập ngày tạo tài khoản");
        LocalDate ngayTao;
        while (true) {
            try {
                ngayTao = LocalDate.parse(sc.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("ngày sai định dạng,nhập lại!");
            }
        }

        System.out.println("Nhập số tiền gửi");
        int soTienGui;
        while (true) {
            try {
                soTienGui = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(soTienGui);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập ngày gửi");
        LocalDate ngayGui;
        while (true) {
            try {
                ngayGui = LocalDate.parse(sc.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("ngày sai định dạng,nhập lại!");
            }
        }
        System.out.println("Nhập lãi suất");
        double laiSuat;
        while (true) {
            try {
                laiSuat = Double.parseDouble(sc.nextLine());
                CheckException.checkNumber(laiSuat);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập kì hạn");
        int kiHan;
        while (true) {
            try {
                kiHan = Integer.parseInt(sc.nextLine());
                CheckException.checkNumber(kiHan);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mời nhập số");
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }
        TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(id, ma, ten, ngayTao, soTienGui, ngayGui, laiSuat, kiHan);
        return taiKhoanTietKiem;
    }
}
