package ss4_oop.practice;

import java.util.Scanner;

public class RectangleDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the height:");
        double height= Double.parseDouble(sc.nextLine());
        System.out.println("enter the width:");
        double width= Double.parseDouble(sc.nextLine());
        Rectangle rectangle=new Rectangle(height,width);
        System.out.println("Your Rectangle \n"+rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+rectangle.getArea());
        System.out.println(rectangle);
    }
}
