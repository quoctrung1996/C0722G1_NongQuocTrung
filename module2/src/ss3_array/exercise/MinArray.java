package ss3_array.exercise;

import ss3_array.practice.Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập độ dài mảng");
        int size=Integer.parseInt(sc.nextLine());
        int[]arr=new int[size];
        for (int i = 0; i < arr.length; i++) {
//            System.out.println("nhập phần tử thứ "+(i+1));
//            arr[i]=Integer.parseInt(sc.nextLine());
            arr[i]=new Random().nextInt(100);
        }
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min>=arr[i]){
                min=arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("GTNN "+min);
    }
}
