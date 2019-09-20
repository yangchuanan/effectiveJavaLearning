package chapter11.item78.fixedstopthread1;

import java.util.concurrent.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 21:10
 * @Description Properly synchronized cooperative thread termination
 * @Version 0.0.1
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}  