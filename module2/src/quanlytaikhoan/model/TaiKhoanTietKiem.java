package quanlytaikhoan.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaiKhoanTietKiem extends TaiKhoanNganHang{
    private int soTienGui;
    private LocalDate ngayGui;
    private double laiSuat;
    private int kiHan;

    public TaiKhoanTietKiem() {
    }
    public TaiKhoanTietKiem(int id, int ma, String ten, LocalDate ngayTao, int soTienGui, LocalDate ngayGui, double laiSuat, int kiHan) {
        super(id, ma, ten, ngayTao);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public int getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(int soTienGui) {
        this.soTienGui = soTienGui;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKiHan() {
        return kiHan;
    }

    public void setKiHan(int kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" +super.toString()+
                "soTienGui=" + soTienGui +
                ", ngayGui=" + ngayGui.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", laiSuat=" + laiSuat +
                ", kiHan=" + kiHan +
                '}';
    }

    @Override
    public String thongTin() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getId(),getMa(),getTen(),getNgayTao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),getSoTienGui(),getNgayGui().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),getLaiSuat(),getKiHan());
    }
}
