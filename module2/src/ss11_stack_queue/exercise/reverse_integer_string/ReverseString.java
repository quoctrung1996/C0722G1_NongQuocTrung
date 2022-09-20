package ss11_stack_queue.exercise.reverse_integer_string;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> wStack = new Stack<>();
        System.out.println("nhập chuỗi cần đảo ngược");
        String s = sc.nextLine();
        String[] word = s.split(" ");
        for (int i = 0; i < word.length; i++) {
            wStack.push(word[i]);
        }
        String mWord = "";
        for (int i = 0; i < word.length; i++) {
            mWord += wStack.pop() + " ";
        }
        System.out.println(mWord);
//        while (!wStack.isEmpty()){
//            System.out.print(wStack.pop());
//        }
    }
}
