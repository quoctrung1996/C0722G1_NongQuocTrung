package ss1_production.practice;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập tháng");
        int month=sc.nextInt();
//        switch (month){
//            case 2:
//                System.out.print("28 hoặc 29 ngày");
//                break;
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.println("31 ngày");
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.println("30 ngày");
//                break;
//            default:
//                System.out.println("k có tháng này");
//        }


        String daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
        }

        if (!daysInMonth.equals("")) System.out.printf("The month %d has %s days!", month, daysInMonth);
        else System.out.print("Invalid input!");
    }
}
