package ss3_array.exercise;

import ss3_array.practice.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ConcatInArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[]arr1=new int[3];
        int[]arr2=new int[4];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("nhập phần tử thứ "+(i+1)+" mảng 1");
            arr1[i]=Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("nhập phần tử thứ "+(i+1)+" mảng 2");
            arr2[i]=Integer.parseInt(sc.nextLine());
        }
        int[]arr3=new int[arr1.length+ arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i]=arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length+i]=arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
