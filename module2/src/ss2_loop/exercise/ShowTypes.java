package ss2_loop.exercise;

import java.util.Scanner;

public class ShowTypes {
    public static void main(String[] args) {
        int choise = -1;
        Scanner sc = new Scanner(System.in);
        while (choise != 0) {
            System.out.println("Menu");
            System.out.println("1,In hình chữ nhật");
            System.out.println("2,In hình tam giác vuông, có cạnh góc vuông ở botton-left");
            System.out.println("3,In hình tam giác vuông, có cạnh góc vuông ở top-left");
            System.out.println("4,In hình tam giác cân");
            System.out.println("0,Exit");
            choise = sc.nextInt();
            String star = "";
            switch (choise) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            star += "*";
                        }
                        star += "\n";
                    }
                    System.out.println(star);
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            star += "*";
                        }
                        star += "\n";
                    }
                    System.out.println(star);
                    break;
                case 3:
                    for (int i = 5; i > 0; i--) {
                        for (int j = i; j > 0; j--) {
                            star += "*";
                        }
                        star += "\n";
                    }
                    System.out.println(star);
                    break;
                case 4:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5 - i; j++) {
                            star += " ";
                        }
                        for (int j = 0; j <= i; j++) {
                            star += "* ";
                        }
                        star += "\n";
                    }
                    System.out.println(star);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("chọn lại");
            }
        }
    }
}
