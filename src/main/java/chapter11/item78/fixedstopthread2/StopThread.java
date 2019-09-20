package chapter11.item78.fixedstopthread2;

import java.util.concurrent.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 21:11
 * @Description Cooperative thread termination with a volatile field
 * @Version 0.0.1
 */
public class StopThread {
    private static volatile boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
