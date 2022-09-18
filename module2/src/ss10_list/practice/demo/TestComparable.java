package ss10_list.practice.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestComparable {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person p3 = new Person(3, "nong quoc trung");
        Person p1 = new Person(1, "nong quoc trung");
        Person p2 = new Person(2, "vo tuyet kha");
        personList.add(p3);
        personList.add(p1);
        personList.add(p2);
//        Person[] people = new Person[2];
//        people[0] = new Person(3, "trung");
//        people[1] = new Person(2, "kha");
//       Person p=new Person();
        Collections.sort(personList,new Person());
//        Arrays.sort(people, new Person());
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
