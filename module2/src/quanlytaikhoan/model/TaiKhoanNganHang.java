package quanlytaikhoan.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class TaiKhoanNganHang {
    private int id;
    private int ma;
    private String ten;
    private LocalDate ngayTao;

    public TaiKhoanNganHang() {
    }

    public TaiKhoanNganHang(int id, int ma, String ten, LocalDate ngayTao) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayTao = ngayTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "TaiKhoanNganHang{" +
                "id=" + id +
                ", ma=" + ma +
                ", ten=" + ten +
                ", ngayDangKi=" + ngayTao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
    public abstract String thongTin();
}
