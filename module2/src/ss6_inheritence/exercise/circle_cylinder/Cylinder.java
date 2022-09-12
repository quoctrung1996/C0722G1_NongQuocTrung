package ss6_inheritence.exercise.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double volume(){
        return super.area()*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +super.toString()+
                "height=" + height +
                '}';
    }
}
