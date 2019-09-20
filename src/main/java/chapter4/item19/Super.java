package chapter4.item19;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:36
 * @Description Class whose constructor invokes an overridable method. NEVER DO THIS! (Page 95)
 * @Version 0.0.1
 */
public class Super {
    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
