package chapter2.item8;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 15:05
 * @Description 通过try{}块实现自动释放对象
 * Well-behaved client of resource with cleaner safety-net (Page 33)
 * @Version 0.0.1
 */
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
