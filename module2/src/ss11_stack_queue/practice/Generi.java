package ss11_stack_queue.practice;

public class Generi<N> {
    public void aVoid(N o){
        
    }
    public N remove(){
        return null;
    }
    public static void main(String[] args) {
        Generi<QueueTest> generi=new Generi<>();
        generi.remove();
        generi.aVoid(new QueueTest());
        Generi a=new Generi();
        a.aVoid(new TeskStack());
        a.aVoid("abc");

        QueueTest queueTest= generi.remove();
    }
}
