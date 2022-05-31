package numberprinterexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        List<Thread> threads = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 100000; ++i) {
            executor.execute(new NumberPrinter(i));
            try {
                Thread.sleep(50L);
            } catch (Exception e) {

            }

            if (i == 40) {
                System.out.println("Debug " + Thread.currentThread().getName());
            }
        }
        try {
            executor.shutdown();
        } catch (Exception e) {
            System.out.println("something is wrong");
        }

    }
}

// Break till 11:12 PM
