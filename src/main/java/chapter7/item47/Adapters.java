package chapter7.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 18:56
 * @Description 从stream变为迭代的适配器
 * Adapters from stream to iterable and vice-versa (Page 216)
 * @Version 0.0.1
 */
public class Adapters {
    /**
     * Adapter from  Stream<E> to Iterable<E>
     */
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    /**
     * Adapter from Iterable<E> to Stream<E>
     */
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
