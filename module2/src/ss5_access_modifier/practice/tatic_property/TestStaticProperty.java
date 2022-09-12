package ss5_access_modifier.practice.tatic_property;

import ss5_access_modifier.practice.student.Student;

public class TestStaticProperty {
    public static void main(String[] args) {

        Car car1 = new Car("trung");
        System.out.println(car1.a);


        System.out.println(Car.numberOfCars);

        Car car2 = new Car("kha");

        System.out.println(Car.numberOfCars);
        System.out.println(car2.b);
    }

}
