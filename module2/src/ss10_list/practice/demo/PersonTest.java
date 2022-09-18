package ss10_list.practice.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(1,"trung");
        Person p2 = new Person(2,"kha");
        Person p3 = new Person(3,"anh");
        //List<Person> listPerson = new ArrayList<>();
        List<Person> listPerson = new LinkedList<>();

        //thêm phần tử vào mảng
        listPerson.add(p1);
        listPerson.add(p2);
        listPerson.add(p3);
        listPerson.add(p3);
        listPerson.remove(1);
        System.out.println(listPerson.get(1).getId());
        //truy xuất phần tử tại vị trí index
//        Person p = listPerson.get(1);
//        System.out.println(p.getId());
//
//        for (Person person : listPerson) {
//            System.out.println(person.getId());
//        }
//        for (int i = 0; i < listPerson.size(); i++) {
//            System.out.println(listPerson.get(i).getId());
//        }
//        //xóa phần tử tại vị trí index
//        listPerson.remove(0);
//        for (Person person : listPerson) {
//            System.out.println(person.getId());
////        }
//        listPerson.remove(p3);
//        listPerson.remove(p3);
//        for (Person person : listPerson) {
//            System.out.println(person.getId());
//        }
    }
}
