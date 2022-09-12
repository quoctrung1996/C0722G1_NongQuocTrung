package ss5_access_modifier.practice.student;

public class Student {
    private int rollno;
    private String name;
    static String college = "BBDIT";
    static String abc="dfsds";
//phương thức khởi tạo constructor
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
