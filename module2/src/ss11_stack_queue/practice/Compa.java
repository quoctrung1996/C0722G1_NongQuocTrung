package ss11_stack_queue.practice;

public class Compa implements Comparable<Compa>{
    private int id;
    private String name;

    public Compa(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Compa o) {
        return -this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Compa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
