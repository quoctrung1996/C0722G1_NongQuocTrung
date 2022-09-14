package ss7_abstract.exercise.interface_colorable;

public class Rectangle implements Colorable{
    private double height ;
    private double weght ;
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
    public void howToColor() {
        System.out.println("Color all four sides..");
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "Area="+getArea()+
                '}';
    }
}
