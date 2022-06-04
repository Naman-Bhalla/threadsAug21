package addersubtractoratomic;

public class Subtractor implements Runnable {
    Value value;

    Subtractor(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
            try {
                Thread.sleep(5L);
            } catch (Exception e) {

            }

            value.subtract(i);
        }
    }
}
