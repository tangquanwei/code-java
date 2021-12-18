package lang.thread;

/**
 * class 线程通信
 * 
 * 线程1,2交替打印1-100
 * 
 * wait():一旦执行此方法,当前线程就会进入阻塞状态,并释放同步监视器
 * 
 * notify():一旦执行此方法,就会唤醒wait的一个优先级最高线程
 * 
 * notifyAll():一旦执行此方法,就会唤醒wait的所有线程
 * 
 * 注意:
 * 
 * 这三个方法只出现再同步方法或代码块中
 * 
 * 这三个方法的调用者都必须是 同一个同步监视器
 * 
 * 都定义在Object类中
 */
// 面试题:
//
// 1.sleep和wait方法的异同
//
// 异:
// 1)声明位置:Thread:sleep,Object:wait
// 2)调用要求:sleep:任何需要时,wait必须在同比代码中
// 3)是否释放同步监视器:sleep:否,wait:是
//
// 同:
// 1)都能使当前线程就会进入阻塞状态
public class ThreadCommunication {
    public static void main(String[] args) {
        var pn = new PrintNumber();
        /**
         * 假如T1先获取到同步监视器,执行到notify()没有其他可以唤醒的线程
         * T1继续执行到wait(),T1线程阻塞并释放同步监视器,T2取得同步监视器
         * T2执行到nitify()唤醒T1,但T1没有取得同步监视器继续等待T2
         * T2执行到wait(),,T2线程阻塞并释放同步监视器,T1取得同步监视器...
         */
        new Thread(pn, "T1 ").start();
        new Thread(pn, "T2 ").start();
    }
}

class PrintNumber implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                this.notify();
                if (number > 100)
                    break;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + number++);
                try {// 使得调用如下wait方法的线程进入阻塞状态
                    this.wait();// 释放同步监视器
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
