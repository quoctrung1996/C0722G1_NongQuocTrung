package ss7_abstract.practice.demo2;

public interface Flyable {
    String fly();

    public static void main(String[] args) {
        Flyable flyableObj = new Flyable() {
            @Override
            public String fly() {
                return "Flying...";
            }
        };
        System.out.println(flyableObj.fly());
    }
}
