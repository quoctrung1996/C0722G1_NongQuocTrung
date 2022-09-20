package ss11_stack_queue.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(9, "A"));
        list.add(new Person(4, "C"));
        list.add(new Person(2, "B"));
//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if (o1.getId() > o2.getId()) return 1;
//                if (o1.getId() < o2.getId()) return -1;
//                return 0;
//            }
//        });
        list.sort((o1,o2) ->{
            if (o1.getId() > o2.getId()) return 1;
                if (o1.getId() < o2.getId()) return -1;
                return 0;
        });
        for (Person person : list) {
            System.out.println(person.getId());
        }
    }
}
