package ss11_stack_queue.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        queue.offer("trung");
        queue.offer("kha");
        queue.offer("anh");
        int size= queue.size();
        for (int i = 0; i <size ; i++) {
            System.out.println(queue.poll());
        }
    }
}
