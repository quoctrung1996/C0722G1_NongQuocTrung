package ss6_inheritence.domo;

public class Cha {
    private String name="trung";
    private String age="18";

    public Cha() {
        System.out.println("hàm khởi tạo cha");
    }

    public Cha(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public void m1(){
        System.out.println("ta là pt thuộc cha");
    }

    @Override
    public String toString() {
        return "Cha{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    public int tinhTien(){
        return 1;
    }
}
