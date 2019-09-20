package chapter3.item10;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 15:25
 * @Description Simple immutable two-dimensional integer point class (Page 37)
 * @Version 0.0.1
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Point)){
            return false;
        }
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    /**
     * 违背里式替换原则  Broken - violates Liskov substitution principle (page 43)
     */
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    /**
     * 重写equal方法是需要重写hashCode方法
     */
    @Override public int hashCode()  {
        return 31 * x + y;
    }
}
