package addersubtractorlock;

public class Value {
    private int value1 = 0;
    private int value2 = 0;

    public void add(int i) {
        value1 += i;
    }

    public void subtract(int i) {
        value1 -= i;
    }

    public int get() {
        return value1;
    }

    public void set(int i) {
        value1 = i;
    }

    public void subtract2(int i) {
        value2 -= i;
    }

    public int get2() {
        return value2;
    }

    public void set2(int i) {
        value2 = i;
    }

    public void add2(int i) {
        value2 += i;
    }
}
