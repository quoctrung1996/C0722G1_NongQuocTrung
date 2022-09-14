package ss7_abstract.exercise.interface_resizeable;

public class TestInterfaceResizeable {
    public static void main(String[] args) {
        Resizeable[] resizeables = new Resizeable[3];
        resizeables[0] = new Circle();
        resizeables[1] = new Rectangle();
        resizeables[2] = new Square();
        System.out.println("Trước khi thay đổi");
        for (Resizeable resizeable : resizeables) {
            System.out.println(resizeable.toString());
        }
        System.out.println("sau khi thay đổi");
        for (Resizeable resizeable : resizeables) {
            resizeable.resize(Math.floor(Math.random()*100));
            System.out.println(resizeable.toString());
        }
    }
}
