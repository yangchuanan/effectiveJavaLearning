package chapter11.item78.brokenstopthread;

import java.util.concurrent.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 21:05
 * @Description Broken! - How long would you expect this program to run?
 * @Version 0.0.1
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        /** **/
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
                System.out.println("test i="+i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}