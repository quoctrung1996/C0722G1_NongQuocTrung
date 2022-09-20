package ss11_stack_queue.practice;

import java.util.Comparator;

public class TestCompara implements Comparator<Compara> {

    @Override
    public int compare(Compara o1, Compara o2) {
        if (o1.getHeiht() > o2.getHeiht()) return 1;
        if (o1.getHeiht() < o2.getHeiht()) return -1;
        return 0;
    }
}
