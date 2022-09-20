package ss11_stack_queue.practice;

import java.util.*;

public class Compara implements Comparable<Compara> {
    private String name;
    private int age;
    private double heiht;

    public Compara(String name, int age, double heiht) {
        this.name = name;
        this.age = age;
        this.heiht = heiht;
    }

    public Compara() {
    }

    public double getHeiht() {
        return heiht;
    }

    public void setHeiht(double heiht) {
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
        return this.name.compareTo(o.name);
    }

//    @Override
//    public int compare(Compara o1, Compara o2) {
//        if (o1.age> o2.age) return 1;
//        if (o1.age<o2.age) return -1;
//        return 0;
//    }

    public static void main(String[] args) {
        Compara comparator1 = new Compara("trung", 26, 1.72);
        Compara comparator2 = new Compara("kha", 21, 2);
        Compara comparator3 = new Compara("trung", 25, 1.70);
        Compara[] comparas=new Compara[3];
        comparas[1]=comparator1;
        comparas[2]=comparator2;
        comparas[0]=comparator3;
        ArrayList<Compara> arrayList = new ArrayList<>();
        arrayList.add(comparator1);
        arrayList.add(comparator2);
        arrayList.add(comparator3);
//        arrayList.sort(comparator1);
//        Comparator<Compara> comparator = new Comparator<Compara>() {
//            @Override
//            public int compare(Compara o1, Compara o2) {
//                if (o1.heiht > o2.heiht) return 1;
//                if (o1.heiht < o2.heiht) return -1;
//                return 0;
//            }
//        };
//        arrayList.sort(comparator);
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);

        Arrays.sort(comparas);
        for (int i = 0; i <comparas.length ; i++) {
            System.out.println(comparas[i]);

        }
        Collections.sort(arrayList, new TestCompara());
        System.out.println(arrayList);

    }


}
