package ss7_abstract.exercise.interface_resizeable;

public class Circle implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "Area="+getArea()+
                '}';
    }

    @Override
    public void resize(double percent) {
        setRadius(radius+radius*percent/100);
    }
}
