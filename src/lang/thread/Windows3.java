package lang.thread;

import java.util.concurrent.locks.ReentrantLock;
/**
 * Look
 */
public class Windows3 implements Runnable {
    private int tickets = 50;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + tickets--);
                } else
                    break;
            } finally {
                lock.unlock();
            }
        }

    }

}
