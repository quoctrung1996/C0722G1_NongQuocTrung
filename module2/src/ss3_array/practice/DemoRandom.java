package ss3_array.practice;

import java.util.Random;

public class DemoRandom  {
    public static void main(String[] args) {
        Random rd = new Random();   // khai báo 1 đối tượng Random
        int number = rd.nextInt();  // trả về 1 số nguyên bất kỳ
        double number1 = rd.nextDouble()*100;// trả về 1 số nguyên bất kỳ
        System.out.printf("Số vừa được sinh ra là %-10.2f", number1);
        System.out.printf("Số vừa được sinh ra là %-20.2f", number1);

//        int number2 = rd.nextInt(4);    // trả về 1 số nguyên nằm trong phạm vi [0...3)
//        System.out.println("Số vừa được sinh ra là " + number2);

    }
}
