package ss1_production.exercise;

import java.util.Scanner;

public class FromUsdToVnd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("input USD");
        int usd= sc.nextInt();
        int rate=23000;
        int vn=usd*rate;
        System.out.printf("%dUSD= %sVND",usd,vn);
    }
}
