package lang.thread;

/**
 * 1.继承Thread类
 * 
 * 2.重写run方法
 * 
 * 3.new Thread子类
 * 
 * 4.调用start()方法
 * 
 * Thread常用方法
 * 
 * 1.start
 * 
 * 2.run
 * 
 * 3.currectThread
 * 
 * 4.getName
 * 
 * 5.setName
 * 
 * 6.yield():释放当前CPU的执行权
 * 
 * 7.join():在线程a中调用线程b的join(),此时线程a进入阻塞状态,直到线程b完成
 * 
 * 8.sleep(long milis):让当前线程睡眠milis毫秒,过后该线程处于阻塞状态
 * 
 * 9.setPriority(int0):1-10 高优先级有更大概率先执行
 * 
 */

public class TestThread {
    public static void main(String[] args) {
        var myThread1 = new MyThread1();
        var myThread2 = new MyThread2();
        myThread1.setName("Even");
        myThread2.setName("Odd");
        myThread1.setPriority(1);
        myThread2.setPriority(Thread.MAX_PRIORITY);
        myThread1.start();
        myThread2.start();

        new Thread("None") {
            public void run() {
                Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
            };
        }.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }
    
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }
}
