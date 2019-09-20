package chapter6.item40;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 22:59
 * @Description Can you spot the bug? (Page 188)
 */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 此处并没有覆盖父类的方法，而是进行了重载
     */
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        // 结果应该是26 而不是260
        System.out.println(s.size());
    }
}
