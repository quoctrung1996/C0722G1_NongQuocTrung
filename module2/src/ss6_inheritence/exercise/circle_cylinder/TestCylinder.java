package ss6_inheritence.exercise.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(2.0,"blue",3.0);
        System.out.println(cylinder);
        System.out.println("volume: "+cylinder.volume());
        System.out.println(cylinder);

        cylinder.setRadius(3.0);
        cylinder.setColor("pink");
        cylinder.setHeight(2.0);
        System.out.println("volume: "+cylinder.volume());
    }
}
