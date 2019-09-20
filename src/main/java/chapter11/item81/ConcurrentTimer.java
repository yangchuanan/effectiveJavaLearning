package chapter11.item81;

import java.util.concurrent.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 21:54
 * @Description Simple framework for timing concurrent execution
 * @Version 0.0.1
 */
public class ConcurrentTimer {
    private ConcurrentTimer() {
    }

    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                // Tell timer we're ready
                ready.countDown();
                try {
                    // Wait till peers are ready
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Tell timer we're done
                    done.countDown();
                }
            });
        }

        // Wait for all workers to be ready
        ready.await();
        long startNanos = System.nanoTime();
        // And they're off!
        start.countDown();
        // Wait for all workers to finish
        done.await();
        return System.nanoTime() - startNanos;
    }
}
