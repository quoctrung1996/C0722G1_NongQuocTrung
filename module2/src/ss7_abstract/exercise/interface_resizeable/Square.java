package ss7_abstract.exercise.interface_resizeable;

public class Square extends Rectangle implements Resizeable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
       this.side=side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                "Area="+getArea()+
                '}';
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public void resize(double percent) {
        setSide(side + side * percent / 100);
    }
}
