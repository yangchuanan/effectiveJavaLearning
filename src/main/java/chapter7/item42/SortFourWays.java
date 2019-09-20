package chapter7.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

import static java.util.Comparator.comparingInt;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/5 21:44
 * @Description Sorting with function objects (Pages 193-4)
 * @Version 0.0.1
 */
public class SortFourWays {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        /**
         * Anonymous class instance as a function object - obsolete! (Page 193)
         */
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        /**
         * Lambda expression as function object (replaces anonymous class) (Page 194)
         */
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        /**
         * Comparator construction method (with method reference) in place of lambda (Page 194)
         */
        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        /**
         * Default method List.sort in conjunction with comparator construction method (Page 194)
         */
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}
