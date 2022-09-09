package ss4_oop.exercise.quadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập a: ");
        double a=Double.parseDouble(sc.nextLine());
        System.out.println("nhập b: ");
        double b=Double.parseDouble(sc.nextLine());
        System.out.println("nhập c: ");
        double c=Double.parseDouble(sc.nextLine());
        QuadraticEquation quadraticEquation=new QuadraticEquation(a,b,c);
        System.out.println(quadraticEquation.toString());

        if(quadraticEquation.getDiscriminant()==0){
            System.out.println("pt có nghiệm kép: x=  "+quadraticEquation.getRoot1());
        }else if(quadraticEquation.getDiscriminant()>0){
            System.out.println("pt có hai nghiệm:\n x1= "+quadraticEquation.getRoot1()
            +"\n x2= "+quadraticEquation.getRoot2());
        }else {
            System.out.println("pt vô nghiệm");
        }
    }
}
