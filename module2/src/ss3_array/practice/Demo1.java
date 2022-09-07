package ss3_array.practice;

public class Demo1 {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        //có hay không có tham số truyền vào thì cũng gọi được hàm
        demo(a);
    }

    //ba chấm là mảng
    public static void demo(int... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

