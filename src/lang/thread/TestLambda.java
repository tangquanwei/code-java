package lang.thread;

import java.time.LocalTime;

public class TestLambda {
    static StringBuffer s=new StringBuffer();
    public static void main(String[] args) {
        Runnable runnable=()->{};
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized(s){System.out.println(Thread.currentThread().getName());}
        }, "线程1").start();

        var t = new Thread(() -> {
            synchronized (s) {
                while (true) {
                    System.out.println(LocalTime.now());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        break;
                    }
                }
            } 
        }, "Daemon");// 守护进程

        t.setDaemon(true);
        t.start();
        var timer = new TimerThread();
        timer.setDaemon(true);
        timer.start();
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}