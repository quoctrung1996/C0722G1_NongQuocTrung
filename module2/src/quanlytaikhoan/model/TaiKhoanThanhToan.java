package quanlytaikhoan.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaiKhoanThanhToan extends TaiKhoanNganHang{
   private String soThe;
   private int soTien;

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(int id, int ma, String ten, LocalDate ngayTao, String soThe, int soTien) {
        super(id, ma, ten, ngayTao);
        this.soThe = soThe;
        this.soTien = soTien;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" +super.toString()+
                "soThe='" + soThe + '\'' +
                ", soTien='" + soTien + '\'' +
                '}';
    }

    @Override
    public String thongTin() {
        return String.format("%s,%s,%s,%s,%s,%s",getId(),getMa(),getTen(),getNgayTao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),getSoThe(),getSoTien());

    }
}
