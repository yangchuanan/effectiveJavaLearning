package chapter3.item14;
import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:23
 * @Description The benefits of implementing Comparable (Page 66)
 * @Version 0.0.1
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
