package ss12_tree_map.practice.hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Person> set=new LinkedHashSet<>();
        set.add(new Person(1));
        set.add(new Person(2));
        set.add(new Person(3));
        set.add(new Person(3));
        set.remove(new Person(1));
        for (Person person:set){
            System.out.println(person.getId());
        }
    }
}
