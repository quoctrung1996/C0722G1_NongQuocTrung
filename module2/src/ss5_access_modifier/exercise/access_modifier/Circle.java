package ss5_access_modifier.exercise.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

//    private double getRadius() {
//        return this.radius;
//    }

//    double getRadius() {
//        return this.radius;
//    }

//    protected double getRadius() {
//        return this.radius;
//    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}
