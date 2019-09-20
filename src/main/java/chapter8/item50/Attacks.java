package chapter8.item50;
import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 19:03
 * @Description Two attacks on the internals of an "immutable" period
 * @Version 0.0.1
 */
public class Attacks {
    public static void main(String[] args) {
        // Attack the internals of a Period instance
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        // Modifies internals of p!
        end.setYear(78);
        System.out.println(p);

        // Second attack on the internals of a Period instance  (Page 233)
        start = new Date();
        end = new Date();
        p = new Period(start, end);
        // Modifies internals of p!
        p.end().setYear(78);
        System.out.println(p);
    }
}
