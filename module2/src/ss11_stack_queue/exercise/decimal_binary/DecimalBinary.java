package ss11_stack_queue.exercise.decimal_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalBinary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập số nguyên");
        int n= Integer.parseInt(sc.nextLine());
        Stack<Integer> stack=new Stack<>();
        while (n>=1){
            stack.push(n%2);
            n=n/2;
        }
        int size=stack.size();
        String string="";
        for (int i=0;i<size;i++) {
            string+=stack.pop();
        }
        System.out.println(string);
    }
}
