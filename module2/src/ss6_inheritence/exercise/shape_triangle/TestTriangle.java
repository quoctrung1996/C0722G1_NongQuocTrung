package ss6_inheritence.exercise.shape_triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Triangle []triangleList=new Triangle[2];
        for (int i = 0; i < triangleList.length; i++) {
            System.out.println("nhập màu sắc tam giác "+ (i+1));
            String color = sc.nextLine();
           // triangleList[i].setColor(sc.nextLine());
            // chưa dùng được set vì chưa tạo mới đối tượng
            System.out.println("nhập cạnh thứ nhấp của tam giác");
            //triangleList[i].setSide1(Double.parseDouble(sc.nextLine()));
            double side1=Double.parseDouble(sc.nextLine());

            System.out.println("nhập cạnh thứ hai của tam giác");
            double side2=Double.parseDouble(sc.nextLine());

            System.out.println("nhập cạnh thứ ba của tam giác");
            double side3=Double.parseDouble(sc.nextLine());

            triangleList[i]=new Triangle(color,side1,side2,side3);
            System.out.println(triangleList[i]);
        }

    }
}
