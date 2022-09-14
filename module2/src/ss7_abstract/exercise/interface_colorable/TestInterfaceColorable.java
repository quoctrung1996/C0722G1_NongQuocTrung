package ss7_abstract.exercise.interface_colorable;

public class TestInterfaceColorable {
    public static void main(String[] args) {
        Colorable[] colorables = new Colorable[3];
        colorables[0] = new Square(2);
        colorables[1] = new Square(4);
        colorables[2] = new Rectangle(4, 3);
        for (Colorable colorable : colorables) {
            System.out.println(colorable.toString());
            if (colorable instanceof Square) {
                colorable.howToColor();
            }
        }
    }
}
