package ss2_loop.practice;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập số tiền gửi");
                double money= sc.nextDouble();
        System.out.println("nhập số tháng gửi");
        int month= sc.nextInt();
        System.out.println("nhập lãi suất");
        double interestRate= sc.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
//            Số_tiền_lãi = Số_tiền_gửi *  tỉ_lệ_lãi_suất (% năm) / 12 * số_tháng_gửi
            totalInterest+=money*(interestRate/100)/12*month;
        }
        System.out.printf(" tiền lãi: %.2f ",totalInterest);
    }
}
