package ss6_inheritence.exercise.circle_cylinder;

import ss3_array.practice.Array;
import ss6_inheritence.exercise.point_moveable_point.MoveablePoint;
import ss6_inheritence.exercise.point_moveable_point.Point;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle(1.0,"red");
        System.out.println(circle);
        System.out.println("area: "+circle.area());
        circle.setColor("black");
        circle.setRadius(1.5);
        System.out.println(circle);
        System.out.println("area: "+circle.area());
    }
}
