package ss11_stack_queue.practice;

import java.util.*;

public class Compara implements Comparable<Compara> {
    private String name;
    private int age;
    private int heiht;

    public Compara(String name, int age, int heiht) {
        this.name = name;
        this.age = age;
        this.heiht = heiht;
    }

    public Compara() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeiht() {
        return heiht;
    }

    public void setHeiht(int heiht) {
        this.heiht = heiht;
    }

    @Override
    public String toString() {
        return "Comparator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heiht=" + heiht +
                '}';
    }

    @Override
    public int compareTo(Compara o) {
        return this.age-(o.age);
    }

//    @Override
//    public int compare(Compara o1, Compara o2) {
//        if (o1.age> o2.age) return 1;
//        if (o1.age<o2.age) return -1;
//        return 0;
//    }
 

    public static void main(String[] args) {
        Compara comparator1 = new Compara("trung", 26, 10);
        Compara comparator2 = new Compara("kha", 21, 2);
        Compara comparator3 = new Compara("trung", 25, 11);
        Compara[] comparas=new Compara[3];
        comparas[1]=comparator1;
        comparas[2]=comparator2;
        comparas[0]=comparator3;
        ArrayList<Compara> arrayList = new ArrayList<>();
        arrayList.add(comparator1);
        arrayList.add(comparator2);
        arrayList.add(comparator3);

        Collections.sort(arrayList, new Comparator<Compara>() {
            @Override
            public int compare(Compara o1, Compara o2) {
                int n=Integer.compare(o1.getAge(),o2.getAge());
                if(n!=0) return n;
                return  o1.getHeiht()-o2.getHeiht();
            }
        });
//        Comparator<Compara> comparator = new Comparator<Compara>() {
//            @Override
//            public int compare(Compara o1, Compara o2) {
//                if (o1.heiht > o2.heiht) return 1;
//                if (o1.heiht < o2.heiht) return -1;
//                return 0;
//            }
//        };
 //       arrayList.sort(comparator);
 //       System.out.println(arrayList);
//        Collections.sort(arrayList);
        System.out.println(arrayList);

//        Arrays.sort(comparas);
//        for (int i = 0; i <comparas.length ; i++) {
//            System.out.println(comparas[i]);
//
//        }
 //       Collections.sort(arrayList, new TestCompara());
        System.out.println(arrayList);

    }


}
