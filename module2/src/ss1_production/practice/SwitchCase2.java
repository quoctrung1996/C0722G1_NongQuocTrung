package ss1_production.practice;

import java.util.Scanner;

public class SwitchCase2 {
    public static void main(String[] args) {
        System.out.println("nhập số");
        Scanner input=new Scanner(System.in);
        int x= input.nextInt();
        switch(x){
            case 1:
            case 2:
                System.out.println("số nhỏ");
        }
    }
}
