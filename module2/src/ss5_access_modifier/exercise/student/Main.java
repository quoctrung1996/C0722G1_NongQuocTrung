package ss5_access_modifier.exercise.student;

public class Main{

    public static void main(String[] args) {
        Student student=new Student();
        student.setName("trung");
        student.setClasses("C03");
        System.out.println(student.getName());
        System.out.println(student.getClasses());
       // System.out.println(abc());
    }
}
