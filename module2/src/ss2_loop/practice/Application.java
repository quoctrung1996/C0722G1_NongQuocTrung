package ss2_loop.practice;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int choise=-1;
        Scanner sc=new Scanner(System.in);

        while (choise!=0) {
            System.out.println("Menu");
            System.out.println("1,Vẽ hình tam giác");
            System.out.println("2,Vẽ hình chữ nhật");
            System.out.println("3,Vẽ hình vuông");
            System.out.println("0,Exit");
            System.out.println("chọn một số");
            choise = sc.nextInt();
            switch (choise){
                case 1:
                    System.out.println("*");
                    System.out.println("**");
                    System.out.println("***");
                    System.out.println("****");
                    System.out.println("*****");
                    break;
                case 2:
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("* * * * ");
                    System.out.println("* * * * ");
                    System.out.println("* * * * ");
                    System.out.println("* * * * ");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("không chọn");
            }
        }
    }
}
