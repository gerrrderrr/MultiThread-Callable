import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> myCallable1 = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();
        Callable<Integer> myCallable4 = new MyCallable();
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int resultOfTask = 0;
        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            final Future<Integer> task1 = threadPool.submit(myCallable1);
            final Future<Integer> task2 = threadPool.submit(myCallable2);
            final Future<Integer> task3 = threadPool.submit(myCallable3);
            final Future<Integer> task4 = threadPool.submit(myCallable4);
            resultOfTask = task1.get() + task2.get() + task3.get() + task4.get();
            if (i == 1) {

                threadPool.shutdown();
            }
        }
        System.out.println(resultOfTask);
    }
}
