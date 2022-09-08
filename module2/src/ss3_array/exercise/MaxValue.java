package ss3_array.exercise;

import ss3_array.practice.Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập độ dài mảng 2 chiều");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.println("nhập độ dài mảng con");
        int num2 = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[num1][num2];
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                arr[i][j] = new Random().nextInt(100);
            }
            System.out.print(Arrays.toString(arr[i]) + ",");
        }
        int max = arr[0][0];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= max) {
                    max = arr[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.printf("\ngtln là %s tại tọa độ %s,%s", max, index1, index2);
    }
}
