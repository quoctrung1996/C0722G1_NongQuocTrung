package ss7_abstract.exercise.interface_resizeable;

public class Rectangle implements Resizeable {
    private double height = 1.0;
    private double weght = 1.0;

    public Rectangle() {
    }

    public Rectangle(double height, double weght) {
        this.height = height;
        this.weght = weght;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeght() {
        return weght;
    }

    public void setWeght(double weght) {
        this.weght = weght;
    }

    public double getArea() {
        return this.height * this.weght;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", weght=" + weght +
                "Area="+getArea()+
                '}';
    }

    @Override
    public void resize(double percent) {
        setHeight(height + height * percent / 100);
        setWeght(weght + weght * percent / 100);
    }
}
