package practice.abstract_;

public class ToaDo {
    private int x;
    private int y;

    public ToaDo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ToaDo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
