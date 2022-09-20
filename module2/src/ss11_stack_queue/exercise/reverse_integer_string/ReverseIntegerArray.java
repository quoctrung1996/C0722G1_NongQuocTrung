package ss11_stack_queue.exercise.reverse_integer_string;

import java.util.Arrays;
import java.util.Stack;

public class ReverseIntegerArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
}
