package chapter9.item61;

/** What does this program do? */
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        /** i为null 拆箱失败 */
        if (i == 42) {
            System.out.println("Unbelievable");
        }
    }
}