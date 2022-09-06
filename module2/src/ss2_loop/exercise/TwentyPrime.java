package ss2_loop.exercise;

public class TwentyPrime {
    public static void main(String[] args) {
        int num = 2;
        for (int i = 0; i < 20; ) {
            boolean result = true;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    result = false;
                    break;
                }
            }
            if (result) {
                System.out.println(num);
                i++;
            }
            num++;
        }
    }
}
