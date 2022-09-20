package ss12_tree_map.practice.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList=new ArrayList<>();
 //       Student[] students=new Student[4];
        Student student4 = new Student("Kien", 30 );
        Student student1 = new Student("Nam", 26);
        Student student2 = new Student("Tung", 38 );
        Student student3 = new Student("Anh", 38 );
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

//        students[0]=student4;
//        students[1]=student1;
//        students[2]=student2;
//        students[3]=student3;
        Collections.sort(studentList);
        for (Student student:studentList){
            System.out.println(student);
        }
        AgeComparator ageComparator=new AgeComparator();
        Collections.sort(studentList,ageComparator);
        System.out.println("sắp xếp theo tuổi");
        for (Student student:studentList){
            System.out.println(student);
        }
    }
}
