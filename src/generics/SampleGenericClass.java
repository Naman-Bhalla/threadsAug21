package generics;

import java.util.ArrayList;
import java.util.List;

public class SampleGenericClass<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    void put(K key, V value) {
        System.out.println("Value is put");
    }

    V get(K key) {
        return null;
    }
}
