package ss11_stack_queue.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TeskStack {
    public static void main(String[] args) {
        // stackChuoi.push("giatri") => đưa giá trị vào stack
        // stackChuoi.pop() => lấy giá trị ra, xóa khỏi stack
        // stackChuoi.peek() => lấy giá trị ra, nhưng không xóa khỏi stack
        // stackChuoi.clear(); => xóa tất cả phần tử trong stack
        // stackChuoi.contains("giatri")=> xác định giá trị có tồn tại trong stack hay không
        // stackChuoi.size() => độ lớn của stack

        Stack<String> stringStack = new Stack<>();
        List<String> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập chuỗi");
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            stringStack.push(s.charAt(i) + "");
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stringStack.pop());
        }
        //Chuyển từ hệ thập phân sang nhị phân
        System.out.println("\n nhập một số từ bàn phím");
        int n= Integer.parseInt(sc.nextLine());
        Stack<Integer> integerStack=new Stack<>();
        while (n>0){
            int soDu=n%2;
            integerStack.push(soDu);
            n=n/2;
        }
        int size=integerStack.size();
        for (int i = 0; i <size ; i++) {
            System.out.print    (integerStack.pop());
        }
    }
}