package ss5_access_modifier.practice.tatic_property;

public class Car {

    private String name;

    private String engine;

    public static int numberOfCars;
    public int a;
    public String b;

    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

    }

    public Car(String name) {
        this.name = name;
        numberOfCars++;

    }

}
