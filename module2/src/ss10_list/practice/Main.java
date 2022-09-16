package ss10_list.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        ArrayList mang=new ArrayList();
//        System.out.println(mang.size());
//        mang.add("trung");
//        System.out.println(mang.size());
//        List<Integer> arrList=new ArrayList<>();
//        List<String> arr2=new ArrayList<>();
//        arrList.add(1);
//        arr2.add("abc");
        public class Main
        {
            public static void main(String[] args) {
                /*Khởi tạo mảng ban đầu*/
                int[] src = {2,4,18};

                /*Sao chép mảng src vào dst*/
                int[] dst = Arrays.copyOf(src, 5);


                /*Kiểm tra mảng kết quả*/
                for(int i = 0; i < dst.length; i++) {
                    System.out.println(dst[i]);
                }

        /*Thử thay đổi mảng ban đầu và kiểm tra
         mảng kết quả có bị thay đổi theo không*/

                src[0] = 8;

                /*Kiểm tra mảng kết quả*/
                for(int i = 0; i < dst.length; i++) {
                    System.out.println(dst[i]);
                }
            }



        }

//}
