package ss10_list.practice.equals;

public class Test {
    public static void main(String[] args) {
        Person p1=new Person(1,"trung");
        Person p2=new Person(2,"kha");
        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
    }
}
