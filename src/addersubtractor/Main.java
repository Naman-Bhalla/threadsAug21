package addersubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        Value value = new Value();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Adder(value));
        executorService.execute(new Subtractor(value));

        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);

        System.out.println(value.get());
        System.out.println("Somethig");

    }
}
