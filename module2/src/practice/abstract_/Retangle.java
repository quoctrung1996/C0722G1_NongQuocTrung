package practice.abstract_;

public class Retangle extends Shape{
    private double weight;
    private double heigth;

    public Retangle(ToaDo toaDo, double weight, double heigth) {
        super(toaDo);
        this.weight = weight;
        this.heigth = heigth;
    }

    @Override
    public double getArea() {
        return this.heigth*this.weight;
    }

    @Override
    public String toString() {
        return "Retangle{" + super.toString()+
                "weight=" + weight +
                ", heigth=" + heigth +
                '}';
    }
}
