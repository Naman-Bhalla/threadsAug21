package multithreadedmergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> list;
    ExecutorService executorService;

    Sorter(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size()/ 2; // 2 -> 1; 3 -> 1; 4 -> 2; 5 -> 2

        List<Integer> left = new ArrayList<>();

        for (int i = 0; i < mid; ++i) { // mid = 1 i = 0, i = 1
            left.add(list.get(i));
        }

        List<Integer> right = new ArrayList<>();

        for (int i = mid; i < list.size(); ++i) {
            right.add(list.get(i));
        }

//        ExecutorService executorService = Executors.newCachedThreadPool();

        // t = 0  t = 0;
        Future<List<Integer>> sortedLeftFuture = executorService.submit(new Sorter(left, executorService)); // a: t = 5 // t = 5
        // line 40 started executing at t = 0
        Future<List<Integer>> sortedRightFuture = executorService.submit(new Sorter(right, executorService)); // b: t = 10; t = 5
        // line 42 started executing at t = 0

        // line 46 starts executing at t = 0
        List<Integer> sortedLeft = sortedLeftFuture.get();
        // line 46 finishes at t = 5
        // line 49 start\s executing at t = 5
        List<Integer> sortedRight = sortedRightFuture.get();
        // line 49 finishes at t= 5

        // t = 10 t = 5
        // a + b v/s max (a, b)

        List<Integer> finalList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < sortedLeft.size() && j < sortedRight.size()) {
            if (sortedLeft.get(i) < sortedRight.get(j)) {
                finalList.add(sortedLeft.get(i));
                i++;
            } else {
                finalList.add(sortedRight.get(j));
                j++;
            }
        }

        while (i < sortedLeft.size()) {
            finalList.add(sortedLeft.get(i));
            i++;
        }

        while (j < sortedRight.size()) {
            finalList.add(sortedRight.get(j));
            j++;
        }

        return finalList;
    }
}
