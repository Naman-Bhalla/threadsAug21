package addersubtractoratomic;

public class Adder implements Runnable {
    Value value;

    Adder(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
            try {
                Thread.sleep(5L);
            } catch (Exception e) {

            }

            value.add(i);
        }
    }
}

// Let's take a break till 10:42 PM
// Concurrent Hash Map