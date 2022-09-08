package ss3_array.exercise;

import java.util.Scanner;

public class CharactersInArray {
    public static void main(String[] args) {
        String str = "nong quoc trung";
        String[] s = str.split("");
        int count = 0;
        // char[]ch=str.toCharArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập kí tự");
        String characters = sc.nextLine();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(characters)) {
                count++;
            }
        }
        System.out.println(count + " lần xuất hiện");
    }
}
