package ss3_array.practice;

public class MinValueInArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1, 7, 9};
        int index = minValue(arr);
        System.out.println(arr[index]);
    }

    public static int minValue(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index] >= arr[i]) {
                index = i;
            }
        }
        return index;
    }
}
