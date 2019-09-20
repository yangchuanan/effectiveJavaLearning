package chapter5.item32;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:07
 * @Description Safe version of PickTwo using lists instead of arrays (Page 150)
 * @Version 0.0.1
 */
public class SafePickTwo {
    static <T> List<T> pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b);
            case 1: return List.of(a, c);
            case 2: return List.of(b, c);
            default:
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        List<String> attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(attributes);
    }
}
