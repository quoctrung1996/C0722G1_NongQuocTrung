package practice.abstract_;

public class Test {
    public static void main(String[] args) {
        ToaDo td1=new ToaDo(2,3);
        ToaDo td2=new ToaDo(1,2);
        Shape h1=new Circle(td1,3);
        Shape h2=new Retangle(td2,3,4);
        System.out.println(td1);
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h1.getArea());
        System.out.println(h2.getArea());
    }
}
