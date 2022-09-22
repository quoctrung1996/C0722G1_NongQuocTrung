package ss13_searching_algorithms.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringMaxLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = sc.nextLine();
        List<Character> max = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            List<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.get(list.size() - 1)) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character ch : max) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
