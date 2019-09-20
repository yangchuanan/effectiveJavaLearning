package chapter11.item84;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 22:01
 * @Description Awful CountDownLatch implementation - busy-waits incessantly!
 * @Version 0.0.1
 */
public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized (this) {
                if (count == 0) {
                    return;
                }
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0) {
            count--;
        }
    }
}
