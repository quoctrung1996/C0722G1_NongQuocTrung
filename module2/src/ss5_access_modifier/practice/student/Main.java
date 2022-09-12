package ss5_access_modifier.practice.student;

public class Main {
    public static void main(String[] args) {
        /*
        calling change method
        tên lớp.phương thức(dùng cho lớp)
         */
        Student.change();

        //creating objects
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        //calling display method
        System.out.println(Student.abc);
        s1.display();
        s2.display();
        s3.display();
    }
}
