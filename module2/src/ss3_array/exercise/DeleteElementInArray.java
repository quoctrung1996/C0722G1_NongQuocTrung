package ss3_array.exercise;

import ss3_array.practice.Array;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 6, 7, 8};
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập phần tử cần xóa");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                i--;
                for (int j = index; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length-1]=0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
