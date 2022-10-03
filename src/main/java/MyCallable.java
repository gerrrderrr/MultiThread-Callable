import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int count;

    @Override
    public Integer call() {
        System.out.println("Привет " + Thread.currentThread().getName());
        if (Thread.currentThread().isAlive()) {
            count++;
        }
        return count;
    }
}
