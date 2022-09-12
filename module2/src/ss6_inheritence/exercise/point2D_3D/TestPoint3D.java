package ss6_inheritence.exercise.point2D_3D;

import java.util.Arrays;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);
        System.out.println(Arrays.toString(point3D.getXYZ()));
        Point3D point3D1 = new Point3D(1.1f,2.2f,3.3f);
        System.out.println(point3D1);
        System.out.println(Arrays.toString(point3D1.getXYZ()));

    }
}
