package ss4_oop.practice;

public class Rectangle {
    double height, width;

    //phương thức khởi tạo không tham số
    public Rectangle() {
    }
    //phương thức khởi tạo 2 tham số
    public Rectangle(double heght, double width) {
        this.width=width;
        this.height =heght;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    //Định nghĩa các phương thức getArea(), getPerimeter(), display()
    public double getArea(){
        return this.height *this.width;
    }
    public double getPerimeter(){
        return (this.width + this.height) * 2;
    }
    public String display(){
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

}

