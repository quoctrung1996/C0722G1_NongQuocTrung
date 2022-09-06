package ss1_production.exercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] str2 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fiveteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] str3 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số cần đọc");
        int a;
        int num = sc.nextInt();
        if (num >= 0 && num < 10) {
            System.out.println(str[num]);
        } else if (num < 20) {
            System.out.println(str2[num - 10]);
        } else if (num < 100) {
            for (int i = 20; i < 100; i += 10) {
                a = num - i;
                if (a >= 1 && a <= 9) {
                    System.out.println(str3[i / 10 - 2] + " " + str[a]);
                    // System.out.println(i);
                } else if (a == 0) {
                    System.out.println(str3[num / 10 - 2]);
                    // System.out.println(i);
                }
            }
        }
    }
}
