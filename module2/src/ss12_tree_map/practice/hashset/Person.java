package ss12_tree_map.practice.hashset;

import java.util.Objects;

public class Person {
    private int id;
    public Person() {
    }
    public Person(int id) {
        this.id = id;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return  (o instanceof Person)?(((Person)o).getId()==this.id):false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
