package chapter2.item8;

import java.lang.ref.Cleaner;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:52
 * @Description 避免使用终结方法和清除方法，实现AutoCloseable接口实现自动释放对象
 * An autocloseable class using a cleaner as a safety net (Page 32)
 * @Version 0.0.1
 */
public class Room implements AutoCloseable {
    // 获取清除实例
    private static final Cleaner cleaner = Cleaner.create();

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:55
     * @Description Resource that requires cleaning. Must not refer to Room!
     */
    private static class State implements Runnable {
        // Number of junk piles in this room
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    /**
     * The state of this room, shared with our cleanable
     */
    private final State state;

    /**
     * Our cleanable. Cleans the room when it’s eligible for gc
     */
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        // this对象幻像可达时，调用state的run()方法
        cleanable = cleaner.register(this, state);
    }

    /**
     * 触发run()方法
     */
    @Override
    public void close() {
        cleanable.clean();
    }
}
