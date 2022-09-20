package ss11_stack_queue.exercise.palindrome_;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập chuỗi");
        String str = sc.nextLine();
        //String str="Able was I ere I saw Elba";
        //String str2 = "nong quoc trung";
        String[] strings = str.toLowerCase().split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals(" ")) {
                stack.push(strings[i]);
                queue.offer(strings[i]);
            }
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
            }
        }
        System.out.println(stack.size() == 0 && queue.size() == 0 ? "giong nhau" : "khac nhau");
    }
}
