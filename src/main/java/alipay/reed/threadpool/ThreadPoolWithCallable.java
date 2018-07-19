package alipay.reed.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author 范群松.
 * Date：2018/7/19
 * Time: 23:00
 */

public class ThreadPoolWithCallable {
    public static void main(String[] args) throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Future future =  pool.submit(new Callable<String>() {
                public String call()  {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Thread.currentThread().getName();
                }
            });
            System.out.println(future.get());
        }
        pool.shutdown();


    }


}
