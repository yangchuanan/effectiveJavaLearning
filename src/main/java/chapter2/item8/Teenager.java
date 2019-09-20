package chapter2.item8;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 15:04
 * @Description 依靠gc实现清理对象工作，不够可靠，因为确定jvm具体何时发生gc
 * Ill-behaved client of resource with cleaner safety-net (Page 33)
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Peace out");

        // Uncomment next line and retest behavior, but note that you MUST NOT depend on this behavior!
//      System.gc();
    }
}
