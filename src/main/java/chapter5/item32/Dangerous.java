package chapter5.item32;

import java.util.List;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:10
 * @Description It is unsafe to store a value in a generic varargs array parameter (Page 146)
 * @Version 0.0.1
 */
public class Dangerous {
    // Mixing generics and varargs can violate type safety!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        // Heap pollution
        objects[0] = intList;
        // ClassCastException
        String s = stringLists[0].get(0);
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
