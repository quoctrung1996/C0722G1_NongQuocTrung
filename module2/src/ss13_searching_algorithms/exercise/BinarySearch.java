package ss13_searching_algorithms.exercise;

import ss3_array.practice.Array;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng");
        int length = Integer.parseInt(sc.nextLine());
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử");
            array[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        return array;
    }

    static int binarySearch(int[] list, int key, int left, int right) {
        if (right >= left) {
            int mid = (left + right) / 2;
            if (key == list[mid]) {
                return mid;
            }
            if (list[mid] > key) {
                return binarySearch(list, key, 0, mid - 1);
            }
            return binarySearch(list, key, mid + 1, right);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println(binarySearch(arr, 4, 0, arr.length - 1));
    }

}