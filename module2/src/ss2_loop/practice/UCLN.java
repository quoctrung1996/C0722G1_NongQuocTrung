package ss2_loop.practice;

import java.util.Scanner;

public interface UCLN {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập số thứ nhất");
        int a= scanner.nextInt();
        System.out.println("nhập số thứ hai");
        int b= scanner.nextInt();
        a=Math.abs(a);
        b=Math.abs(b);
        if(a==0||b==0){
            System.out.println("không có ucln");
        }else {
        while (a!=b){
            if (a>b){
                a=a-b;
            }else {
                b=b-a;
            }
        }
            System.out.println("ucln: "+a);
        }
    }
}
