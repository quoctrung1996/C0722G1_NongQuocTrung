package ss2_loop.practice;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào một số ");
        int num = sc.nextInt();
        boolean result = true;
        if (num < 2) {
            result = false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result = false;
            }
        }
        if (result) {
            System.out.println("là snt");
        } else {
            System.out.println("không là snt");
        }
    }
}
