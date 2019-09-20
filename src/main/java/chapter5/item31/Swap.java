package chapter5.item31;
import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 20:41
 * @Description Private helper method for wildcard capture (Page 145)
 * @Version 0.0.1
 */
public class Swap {
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // Private helper method for wildcard capture
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        // Swap the first and last argument and print the resulting list
        List<String> argList = Arrays.asList(args);
        swap(argList, 0, argList.size() - 1);
        System.out.println(argList);
    }
}
