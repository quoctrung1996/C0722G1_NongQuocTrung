package ss10_list.practice.demo;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    private int id;
    private String name;

    public Person(int id,String name) {
        this.id = id;
        this.name=name;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public String getName(){
        String s=this.name.trim();
        if(s.indexOf(" ")>=0){
           int index=s.lastIndexOf(" ");
           return s.substring(index+1);
        }
        return s;
    }

//    @Override
//    public int compareTo(Person o) {
//
//        return this.getName().compareTo(o.getName());
//    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getId()-o2.getId();
    }
}
