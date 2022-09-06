package ss1_production.practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float height;
        float weight;
        Scanner input=new Scanner(System.in);
        System.out.println("nhập chiều dài");
        height=input.nextFloat();
        System.out.println("nhập chiều rộng");
        weight=input.nextFloat();
        float area=height*weight;
        System.out.println("diện tích là: "+area);
    }
}
