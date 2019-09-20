package chapter8.item52;
import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 19:19
 * @Description What does this program print?
 * @Version 0.0.1
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        // 基本类型，重载方法，去除的是下标对应的值
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);
    }
}
