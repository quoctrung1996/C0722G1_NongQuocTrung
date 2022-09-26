package ss15_exception.exercise;

import java.util.Scanner;

public class CheckIllegalTriangleException {
    public void checkTriangle(double n) throws IllegalTriangleException {
        if (n <= 0) {
            throw new IllegalTriangleException("Cạnh k được nhỏ hơn 0,mời nhập lại");
        }
    }

    public void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn 1 cạnh\n Không phải là ba cạnh của tam giác");
        }
    }

    public static void main(String[] args) {
        CheckIllegalTriangleException checkIllegalTriangleException = new CheckIllegalTriangleException();
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;
        while (true) {
            try {
                System.out.println("nhập cạnh thứ nhất của tam giác:");
                a = Double.parseDouble(scanner.nextLine());
                checkIllegalTriangleException.checkTriangle(a);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("hãy nhập số,mời nhập lại");
            }
        }

        while (true) {
            try {
                System.out.println("nhập cạnh thứ hai của tam giác:");
                b = Double.parseDouble(scanner.nextLine());
                checkIllegalTriangleException.checkTriangle(b);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("hãy nhập số,mời nhập lại");
            }
        }

        while (true) {
            try {
                System.out.println("nhập cạnh thứ ba của tam giác:");
                c = Double.parseDouble(scanner.nextLine());
                checkIllegalTriangleException.checkTriangle(c);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("hãy nhập số,mời nhập lại");
            }
        }

        try {
            checkIllegalTriangleException.checkTriangle(a, b, c);
            System.out.printf("Ba cạnh của tam giác là %f,%f,%f", a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
