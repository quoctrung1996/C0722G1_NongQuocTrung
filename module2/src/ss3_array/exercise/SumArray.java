package ss3_array.exercise;

import java.util.Random;
import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số cột cho mảng");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.println("nhập độ dài cho cột");
        int num2 = Integer.parseInt(sc.nextLine());
        double[][] arr = new double[num1][num2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new Random().nextInt(10);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("bạn muốn tính cột số mấy");
        int input = Integer.parseInt(sc.nextLine());
        double sum = 0;
        for (int i = 0; i < arr[input - 1].length; i++) {
            sum += arr[input - 1][i];
        }
        System.out.printf("cột %d có tổng là %s", input, sum);
    }
}
