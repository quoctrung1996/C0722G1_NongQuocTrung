package ss5_access_modifier.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle();
        Circle circle1=new Circle(2.0);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        System.out.println(circle1.getRadius());
        System.out.println(circle.getArea());
    }

}
