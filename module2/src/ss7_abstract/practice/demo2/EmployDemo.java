package ss7_abstract.practice.demo2;

public class EmployDemo implements Employ,Animal{
    @Override
    public void luong() {
        System.out.println("luong");
    }

    @Override
    public void them() {

    }

    @Override
    public void sua() {

    }

    @Override
    public void xoa() {

    }

    public static void main(String[] args) {
        Employ e=new EmployDemo();
        Animal a=new EmployDemo();

        e.luong();
        a.them();

    }
}
