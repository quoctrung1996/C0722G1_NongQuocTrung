package ss6_inheritence.practice;

public class Demo {
    String name="Trung";
    int age=10;
    String gender="male";
    Demo(){
    }
    Demo(String name,int age){
        this.name=name;
        this.age=age;
    }
    Demo(String name,int age,String gender){
        this(name, age);
        this.gender=gender;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Demo d=new Demo("a",18,"mail");
        System.out.println(d);
    }
}
