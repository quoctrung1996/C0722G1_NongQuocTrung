package ss3_array.exercise;

import ss3_array.practice.Array;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số lượng phần tử");
        int num = Integer.parseInt(sc.nextLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("nhập số cần chèn vào mảng");
        int num2 = Integer.parseInt(sc.nextLine());
        System.out.println("nhập vị trí cần chèn");
        int index = Integer.parseInt(sc.nextLine());
        System.out.println(Arrays.toString(arr));
        if (index < 0 || index > arr.length - 1) {
            System.out.println("không chèn được phần tử vào mảng");
        } else {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = num2;
            System.out.println(Arrays.toString(arr));
        }
    }
}
