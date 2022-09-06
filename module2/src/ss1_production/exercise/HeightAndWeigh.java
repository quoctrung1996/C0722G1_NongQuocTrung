package ss1_production.exercise;

import java.util.Scanner;

public class HeightAndWeigh {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("số đo cần đọc");
        int num= sc.nextInt();
        if (num>=0&&num<10){
            switch (num){
                case 0:
                    System.out.println("không");
                    break;
                case 1:
                    System.out.println("một");
                    break;
                case 2:
                    System.out.println("hai");
                    break;
                case 3:
                    System.out.println("ba");
                    break;
                case 4:
                    System.out.println("bốn");
                    break;
                case 5:
                    System.out.println("năm");
                    break;
                case 6:
                    System.out.println("sáu");
                    break;
                case 7:
                    System.out.println("bảy");
                    break;
                case 8:
                    System.out.println("tám");
                    break;
                case 9:
                    System.out.println("chín");
                    break;
            }
        }else if(num>=10&&num<20){
        }
    }
}
