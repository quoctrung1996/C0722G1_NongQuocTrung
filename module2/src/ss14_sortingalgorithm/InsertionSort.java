package ss14_sortingalgorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array){
        int value;
        int index;
        for(int i = 1; i < array.length; i++){
            value = array[i];
            index = i;
            while(index > 0 && value < array[index-1]){
                array[index] = array[index-1];
                index--;
            }
            array[index] = value;
        }
    }
    public static void main(String[] args) {
        int[] array={1,3,6,8,3,5,7};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
