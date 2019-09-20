package chapter6.item39.markerannotation;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 23:09
 * @Description Program containing marker annotations (Page 181)
 * @Version 0.0.1
 */
public class Sample {
    @Test
    public static void m1() { }        // Test should pass
    public static void m2() { }
    @Test public static void m3() {    // Test should fail
        throw new RuntimeException("Boom");
    }
    public static void m4() { }  // Not a test
    @Test public void m5() { }   // INVALID USE: nonstatic method
    public static void m6() { }
    @Test public static void m7() {    // Test should fail
        throw new RuntimeException("Crash");
    }
    public static void m8() { }
}