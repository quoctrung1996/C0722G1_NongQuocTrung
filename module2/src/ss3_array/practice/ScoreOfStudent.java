package ss3_array.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ScoreOfStudent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size;
        do {
            System.out.println("nhập độ dài mảng");
            size=Integer.parseInt(sc.nextLine());
            if (size>20){
                System.out.println("độ dài lớn hơn 20,vui lòng nhập lại");
            }
        }while (size>20);
        int[]arr=new int[size];
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=new Random().nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=5&&arr[i]<=10){
                count++;
            }
        }
        System.out.printf("có %d học sinh thi đỗ",count);
    }
}
