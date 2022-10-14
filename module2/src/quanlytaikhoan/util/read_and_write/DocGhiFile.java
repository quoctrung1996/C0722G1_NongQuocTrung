package quanlytaikhoan.util.read_and_write;

import quanlytaikhoan.model.TaiKhoanNganHang;
import quanlytaikhoan.model.TaiKhoanThanhToan;
import quanlytaikhoan.model.TaiKhoanTietKiem;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    public static final String FILE = "src/quanlytaikhoan/data/bank_accounts.csv";

    public static List<TaiKhoanNganHang> docFile() {
        List<TaiKhoanNganHang> taiKhoanNganHangList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            TaiKhoanTietKiem taiKhoanTietKiem;
            TaiKhoanThanhToan taiKhoanThanhToan;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                if (info.length == 8) {
                    taiKhoanTietKiem = new TaiKhoanTietKiem(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], LocalDate.parse(info[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")), Integer.parseInt(info[4]), LocalDate.parse(info[5], DateTimeFormatter.ofPattern("dd/MM/yyyy")), Double.parseDouble(info[6]), Integer.parseInt(info[7]));
                    taiKhoanNganHangList.add(taiKhoanTietKiem);
                }else {
                    taiKhoanThanhToan=new TaiKhoanThanhToan(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], LocalDate.parse(info[3],DateTimeFormatter.ofPattern("dd/MM/yyyy")),info[4],Integer.parseInt(info[5]));
                taiKhoanNganHangList.add(taiKhoanThanhToan);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taiKhoanNganHangList;
    }
    public static void ghiFile(List<TaiKhoanNganHang> taiKhoanNganHangList){
        try {
            FileWriter fileWriter = new FileWriter(FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (TaiKhoanNganHang taiKhoanNganHang:taiKhoanNganHangList){
                bufferedWriter.write(taiKhoanNganHang.thongTin());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
