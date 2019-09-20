package chapter5.item32;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:06
 * @Description Subtle heap pollution (Pages 147-8)
 * @Version 0.0.1
 */
public class PickTwo {
    // UNSAFE - Exposes a reference to its generic parameter array!
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
            default:
        }
        // Can't get here
        throw new AssertionError();
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(Arrays.toString(attributes));
    }
}
