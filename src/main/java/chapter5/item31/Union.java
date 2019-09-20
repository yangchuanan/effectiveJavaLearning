package chapter5.item31;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 20:37
 * @Description 使用通配符的泛型类，更加灵活
 * Generic union method with wildcard types for enhanced flexibility (Pages 142-3)
 * @Version 0.0.1
 */
public class Union {
    public static <E> Set<E> union(Set<? extends E> s1,
                                   Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise flexible generic staticfactory
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);

        Set<Double> doubles = new HashSet<>();
        doubles.add(2.0);
        doubles.add(4.0);
        doubles.add(6.0);

        Set<Number> numbers = union(integers, doubles);

//      // Explicit type parameter - required prior to Java 8
//      Set<Number> numbers = Union.<Number>union(integers, doubles);

        System.out.println(numbers);
    }
}
