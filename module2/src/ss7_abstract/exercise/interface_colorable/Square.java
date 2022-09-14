package ss7_abstract.exercise.interface_colorable;

public class Square implements Colorable {
    public void howToColor() {
        System.out.println("Color all four sides..");
    }

    private double side = 1.0;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "Area="+getArea()+
                '}';
    }
}
