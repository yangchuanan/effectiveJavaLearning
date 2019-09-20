package chapter4.item19;

import java.time.Instant;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 21:10
 * @Description 不能重写父类的构造方法
 * Demonstration of what can go wrong when you override a method  called from constructor (Page 96)
 * @Version 0.0.1
 */
public final class Sub extends Super {
    // Blank final, set by constructor
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // Overriding method invoked by superclass constructor
    @Override public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        // 会首先调用父类的构造方法，然后就会调用override方法，此时instant还没有初始化
        // 所以会打印出null
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
