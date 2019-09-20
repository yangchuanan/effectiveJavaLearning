package chapter2.item6;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:22
 * @Description 验证自动拆箱对程序性能的影响
 * Hideously slow program! Can you spot the object creation? (Page 24)
 * @Version 0.0.1
 */
public class Sum {

    private static long sum() {
//        long sum = 0L;
        // 求和是会自动拆箱
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt("10");
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            // 获取高精度的jvm当前时间，纳秒
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42) {
            System.out.println();
        }
    }
}