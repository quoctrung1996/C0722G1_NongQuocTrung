package ss1_production.practice;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("giải phương trình bậc 1 ax+b=c");
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập a ");
        double a = sc.nextDouble();
        System.out.println("nhập b ");
        double b = sc.nextDouble();
        System.out.println("nhập c ");
        double c = sc.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.println("nghiệm :" + answer);
        } else {
            if (b == c) {
                System.out.println("pt vô số nghiệm");
            } else {
                System.out.println("pt vô nghiệm");
            }
        }
    }
}
