package chapter5.item26;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:54
 * @Description Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)
 * @Version 0.0.1
 */
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        // Has compiler-generated cast
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}

