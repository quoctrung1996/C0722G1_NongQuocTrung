package ss3_array.exercise;

import java.util.Arrays;

public class Split {
    public static void main(String[] args) {
        String s ="Xin chào các bạn, tui là Peter!";

        String[] a = s.split("");
        System.out.println(Arrays.toString(a));
        System.out.println(a[4]);

        char[] ch = s.toCharArray();
        System.out.println(ch[16]);


        String[] b = s.split(",");
        System.out.println(Arrays.toString(b));
        System.out.println(b[0]);


        String s2 = "Xin chào, mình là Peter. Mình là lập trình viên!";
        String[] c = s2.split("\\.|\\,");
        System.out.println(Arrays.toString(c));
        System.out.println(c[2]);

        String s3 = "Nguyen Van A";
        String[] d= s3.split(" ");
        System.out.println(Arrays.toString(d));
        System.out.println("Tên: "+d[d.length-1]);
    }
}
