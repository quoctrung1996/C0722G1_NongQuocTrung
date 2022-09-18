package practice.abstract_;

public abstract class Shape {
    private ToaDo toaDo;

    public Shape(ToaDo toaDo) {
        this.toaDo = toaDo;
    }
    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape{" +
                "toaDo=" + toaDo +
                '}';
    }
}
