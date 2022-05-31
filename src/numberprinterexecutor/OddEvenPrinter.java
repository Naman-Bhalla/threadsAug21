package numberprinterexecutor;

import numberprinterexecutor.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter {

    public static void main(String[] args) {
        ExecutorService evenExecutor = Executors.newSingleThreadExecutor();
        ExecutorService oddExecutor = Executors.newSingleThreadExecutor();


        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) {
                evenExecutor.execute(new NumberPrinter(i));
            } else {
                oddExecutor.execute(new NumberPrinter(i));
            }
        }
    }
}
