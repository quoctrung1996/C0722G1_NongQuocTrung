package ss15_exception.practice;

import java.util.Scanner;

public class CheckIllegalTriangleException {
    public void checkTriangle(int n) throws IllegalTriangleException {
        if (n <= 0) {
            throw new IllegalTriangleException("cạnh không được nhỏ hơn 0");
        }
    }

    public void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("tổng hai cạnh phải lớn hơn 1 cạnh");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CheckIllegalTriangleException checkIllegalTriangleException = new CheckIllegalTriangleException();
        int a;
        int b;
        int c;
        while (true) {
            try {
                System.out.println("nhập cạnh thứ nhất");
                a = Integer.parseInt(sc.nextLine());
                checkIllegalTriangleException.checkTriangle(a);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("nhập cạnh thứ hai");
                b = Integer.parseInt(sc.nextLine());
                checkIllegalTriangleException.checkTriangle(b);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("nhập cạnh thứ ba");
                c = Integer.parseInt(sc.nextLine());
                checkIllegalTriangleException.checkTriangle(c);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            checkIllegalTriangleException.checkTriangle(a,b,c);
            System.out.printf("ba cạnh của tam giác lần lượt là %d,%d,%d",a,b,c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
