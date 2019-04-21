package alipay.reed.threadpool;

import java.util.concurrent.CountDownLatch;

/**
 * created by reedfan on 2019/4/21 0021
 */
public class TestCountDownLatch {
    /*
    CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
    用例：主线程等其他线程执行完之后再继续执行，比如计算运算时间
     */

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(50);
        LatchDemo ld = new LatchDemo(latch);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 50; i++) {
            new Thread(ld).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();

        System.out.println("耗费时间为：" + (end - start));
    }

    


}

class LatchDemo implements Runnable{
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }


    public void run() {
        try {
            for (int i = 0; i < 5000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            latch.countDown();
        }
    }
}
