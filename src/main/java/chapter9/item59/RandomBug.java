package chapter9.item59;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 20:03
 * @Description Random number generation is hard! - Page 215
 * @Version 0.0.1
 */
public class RandomBug {
    /**
     * Common but deeply flawed!
     */
    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
            System.out.println(low);
        }
    }
}
