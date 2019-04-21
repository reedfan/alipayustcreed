import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by reedfan on 2019/4/21 0021
 *
 * ABC交错打印
 */
public class TestABCAlternate {

    public static void main(String[] args) {

        final AlternateDemo alternateDemo = new AlternateDemo();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5 ; i++) {
                    alternateDemo.loopA(i);
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    alternateDemo.loopB(i);

                }
            }
        },"B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5 ; i++) {
                    alternateDemo.loopC(i);
                    System.out.println("------");

                }
            }
        },"c").start();



    }


}


class AlternateDemo{

    private volatile int number = 1;  //当前正在执行线程的标记
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public   void loopA(int totalLoop){
        lock.lock();

        try {
            // 1.判断
            if(number != 1){
                condition1.await();
            }
            //2 打印
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" "+i+" "+totalLoop);

            }
            //3.唤醒
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop){
        lock.lock();

        try {
            //1. 判断
            if(number != 2){
                condition2.await();
            }

            //2. 打印
            for (int i = 0; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //3. 唤醒
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop){
        lock.lock();

        try {
            //1. 判断
            if(number != 3){
                condition3.await();
            }

            //2. 打印
            for (int i = 0; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //3. 唤醒
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



}
