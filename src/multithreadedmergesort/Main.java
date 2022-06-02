package multithreadedmergesort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> list = List.of(
                1, 5, 3, 6, 2, 7
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> sortedListFuture = executorService.submit(
                new Sorter(list, executorService)
        );

        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);

        // ExecutorService e = Executors.....
        // void e.execute(Runnable)
        // T return = e.execute(Callable)
        // Thread t = new Thread(Callable)
        // t.start()


    }
}
