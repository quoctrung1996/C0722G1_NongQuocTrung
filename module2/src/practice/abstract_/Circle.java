package practice.abstract_;

public class Circle extends Shape{
    private double radius;

    public Circle(ToaDo toaDo,double radius) {
        super(toaDo);
        this.radius=radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString()+
                "radius=" + radius +
                '}';
    }
}
