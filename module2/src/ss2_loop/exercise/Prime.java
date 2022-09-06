package ss2_loop.exercise;

public class Prime {
    public static void main(String[] args) {
        for (int num = 2; num < 100; num++) {
            boolean result = true;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    result = false;
                    break;
                }
            }
            if (result) {
                System.out.println(num);
            }
        }
    }
}
