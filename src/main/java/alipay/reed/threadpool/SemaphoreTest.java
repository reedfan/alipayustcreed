package alipay.reed.threadpool;

import java.util.concurrent.Semaphore;

/**
 * created by reedfan on 2019/4/21 0021
 * Semaphore维护了一个许可集合，在创建Semaphore的时候，设置上许可数，
 * 每条线程在只有在获得一个许可的时候才可以继续往下执行逻辑
 * （申请一个许可，则Semaphore的许可池中减少一个许可），没有获得许可的线程会进入阻塞状态。
 *
 * Semaphore可以用于做流量控制，特别公用资源有限的应用场景，
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //创建一个Semaphore 有5条许可
        final Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10 ; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(finalI);
                        Thread.sleep(1000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
