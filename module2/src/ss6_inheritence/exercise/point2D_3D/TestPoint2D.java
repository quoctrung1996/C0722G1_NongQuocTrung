package ss6_inheritence.exercise.point2D_3D;

import java.util.Arrays;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2D=new Point2D();
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));
        Point2D point2D1=new Point2D(1.1f,2.2f);
        System.out.println(point2D1);
        System.out.println(Arrays.toString(point2D1.getXY()));
    }
}
