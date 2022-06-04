package addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Value value;
    Lock lockForValue1;
    Lock lockForValue2;

    Adder(Value value, Lock lockForValue1, Lock lockForValue2) {
        this.value = value;
        this.lockForValue1 = lockForValue1;
        this.lockForValue2 = lockForValue2;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
            try {
                Thread.sleep(5L);
            } catch (Exception e) {

            }

            lockForValue1.lock();
            int current = value.get();
            int next = current + i;
            value.set(next);
            lockForValue1.unlock();
        }
    }
}
