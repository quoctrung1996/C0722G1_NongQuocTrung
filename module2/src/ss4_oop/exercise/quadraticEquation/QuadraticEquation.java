package ss4_oop.exercise.quadraticEquation;

public class QuadraticEquation {
   private double a;
   private double b;
   private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        return b*b-4*a*c;
    }
    public double getRoot1(){
        return (-b+Math.pow(getDiscriminant(),0.5))/(2*a);
    }
    public double getRoot2(){
        return (-b-Math.pow(getDiscriminant(),0.5))/(2*a);
    }

    @Override
    public String toString() {
        return "phương trình bậc hai: " +
                  a +" x2 +"+
                  b +" x +"+
                  c +"c=0"
                ;
    }
}
