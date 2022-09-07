package ss3_array.practice;

import java.util.Scanner;

public class ValueInArray {
    public static void main(String[] args) {
        String[] str = {"trung", "nam", "long"};
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên");
        String input = sc.nextLine();
        boolean isExit = false;
        //int count=0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(input)) {
                System.out.println(input + " có trong mảng");
                isExit = true;
                //count++;
            }
        }
//        if(count==0){
//            System.out.println("không có trog mảng");
//        }
        if (!isExit) {
            System.out.println("không có trog mảng");

        }
    }
}
