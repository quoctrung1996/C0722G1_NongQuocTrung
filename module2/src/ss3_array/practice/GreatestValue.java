package ss3_array.practice;

import java.io.PrintStream;
import java.util.Scanner;

public class GreatestValue {
    public static void main(String[] args) {
        int size=1;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("nhập độ dài mảng");
            size=Integer.parseInt(sc.nextLine());
            if(size>20){
                System.out.println("nhập lại độ dài mảng <20");
            }
        }while (size>20);
        int[]arr=new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("nhập phần tử thứ: "+(i+1));
            arr[i]=Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        int max=arr[0];
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=max){
                max=arr[i];
                index=i;
            }
        }
        System.out.printf("Gtln là %d tại vị trí %s",max,index);
    }
}
