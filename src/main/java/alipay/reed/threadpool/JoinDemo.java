package alipay.reed.threadpool;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * join()方法挂起调用线程的执行，直到被调用的对象完成它的执行
 * 在t2线程中，t2本身就是调用线程，所谓的调用线程就是调用了t.join()方法的线程对象既t1

 */
public class JoinDemo {

    public static void main(String[] args) {
        //初始化线程t1,由于后续有匿名内部类调用这个对象,需要用final修饰
        final Thread t1 = new Thread(new Runnable() {


            public void run() {
                System.out.println("t1 is running");
            }
        });
        //初始化线程t2,由于后续有匿名内部类调用这个对象,需要用final修饰
        final Thread t2 = new Thread(new Runnable() {


            public void run() {
                try {
                    //t1调用join方法,t2会等待t1运行完之后才会开始执行后续代码
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("t2 is running");
                }
            }
        });
        //初始化线程t3
        Thread t3 = new Thread(new Runnable() {


            public void run() {
                try {
                    //t2调用join方法,t3会等待t2运行完之后才会开始执行后续代码
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("t3 is running");
                }
            }
        });
        //依次启动3个线程
        t1.start();
        t2.start();
        t3.start();
    }
}
