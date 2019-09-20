package chapter2.item6;

import java.util.regex.Pattern;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:32
 * @Description 重用创建昂贵的对象，提升性能
 * Reusing expensive object for improved performance (Pages 22 and 23)
 * @Version 0.0.1
 */
public class RomanNumerals {
    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:35
     * @Description 可以被优化的方法
     * @Version 0.0.1
     */
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:33
     * @Description 创建模式对象
     * Reusing expensive object for improved performance (Page 23)
     * @Version 0.0.1
     */
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:35
     * @Description 优化后的方法
     * @Version 0.0.1
     */
    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt("10");
        int numReps = Integer.parseInt("10");
        boolean b = false;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                // Change Slow to Fast to see performance difference
//                b ^= isRomanNumeralSlow("MCMLXXVI");
                b ^= isRomanNumeralFast("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        // Prevents VM from optimizing away everything.
        if (!b) {
            System.out.println();
        }
    }
}

