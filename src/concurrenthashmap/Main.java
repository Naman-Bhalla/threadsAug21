package concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();

        String someString = "hi how are you";

        for (Character character: someString.toCharArray()) {

//            if (!map.containsKey(character)) {
//                map.put(character, 1);
//            } else {
//                int currentCount = map.get(character);
//                int next = currentCount + 1;
//                map.put(character, next);
//            }

            map.compute(character, (((character1, integer1) -> {
                if (integer1 == null) {
                    return 1;
                }
                return integer1 + 1;
            })));

//            map.computeIfAbsent() -> ATOMIC
//            v/s
//            if (!map.contains(character)) { -> NON ATOMIC
//
//            }

//            map.computeIfPresent(character, ((character1, integer) -> integer + 1));
//            if (map.containsKey(character)) {
//
//            }

        }
    }
}
