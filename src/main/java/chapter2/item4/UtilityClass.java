package chapter2.item4;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:18
 * @Description 工具类构造函数私有化，不可实例化
 * Noninstantiable utility class (Page 19)
 * @Version 0.0.1
 */
public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
    // 工具类的静态方法
}
