package addersubtractor;

public class Adder implements Runnable {
    Value value;

    Adder(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
//        synchronized (value) {
            for (int i = 1; i <= 100; ++i) {
                try {
                    Thread.sleep(5L);
                } catch (Exception e) {

                }

//            value.add(i);
                synchronized (value) {
                    int current = value.get();
                    int next = current + 1;
                    value.set(next);
                }
//            }

        }


    }
}
