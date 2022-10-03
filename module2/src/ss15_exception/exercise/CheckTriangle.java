package ss15_exception.exercise;

import java.util.Scanner;

public class CheckTriangle {
    public void checkTriangle(int n) throws TriangleException {
        if (n <= 0) {
            throw new TriangleException("Cạnh không được nhỏ hơn 0,xin mời nhập lại");
        }
    }
    public void checkTriangle(int a,int b,int c) throws TriangleException {
        if (a+b<=c||a+c<=b||b+c<=a){
            throw new TriangleException("hai cạnh không được bé hơn một cạnh,\nKhông phải là ba cạnh của tam giác");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CheckTriangle checkTriangle=new CheckTriangle();
        System.out.println("nhập vào cạnh thứ nhất:");
        int a,b,c;
        while (true) {
            try {
                 a = Integer.parseInt(sc.nextLine());
                checkTriangle.checkTriangle(a);
                break;
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("nhập vào cạnh thứ hai:");
        while (true) {
            try {
                 b = Integer.parseInt(sc.nextLine());
                checkTriangle.checkTriangle(b);
                break;
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("nhập vào cạnh thứ ba:");
        while (true) {
            try {
                 c = Integer.parseInt(sc.nextLine());
                checkTriangle.checkTriangle(c);
                break;
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            checkTriangle.checkTriangle(a,b,c);
            System.out.println(a+","+b+","+c+" là ba cạnh của tam giác");
        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
