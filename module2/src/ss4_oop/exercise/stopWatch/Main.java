package ss4_oop.exercise.stopWatch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        for (long i = 0; i < 10000; i++) {
            for (long j = 0; j < 10000 ; j++) {
                j *= 1;
            }
        }
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
