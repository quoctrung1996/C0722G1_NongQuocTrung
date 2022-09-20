package ss11_stack_queue.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompaTest {
    public static void main(String[] args) {
        List<Compa> compaList=new ArrayList<>();
        compaList.add(new Compa(5,"A"));
        compaList.add(new Compa(2,"C"));
        compaList.add(new Compa(13,"B"));
        for (Compa compa:compaList){
            System.out.println(compa);
        }
        Collections.sort(compaList);
        for (Compa compa:compaList){
            System.out.println(compa);
        }
    }
}
