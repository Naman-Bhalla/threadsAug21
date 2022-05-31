package numberprinter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
//            Thread t = new HelloPrinterThreadExtend(23);
//            t.start();
//            Thread t = new Thread(new HelloPrinter());
//            t.start();
//            Thread t = new Thread(new NumberPrinter(i));
//            t.start();
            // Memory for a new thread will be created
            // The new thread will be put in the queue of OS
            // Program will proceed ahead
//            threads.add(t);

            new NumberPrinter(i).run();

            if (i == 40) {
                System.out.println("Debug");
            }
        }
    }
}
