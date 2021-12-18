package lang.thread;
/**
 * 同步方法
 */
public class Windows2 implements Runnable {
    private static int sTickets=50;

    private int tickets = 50;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            sShow();
            if (tickets <= 0)
                break;
        }
    }

    private synchronized void show() {// 同步监视器this
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(Thread.currentThread().getName() + " : " + tickets);
            --tickets;
        }
    }
    private static synchronized void sShow() {// 同步监视器this
        if (sTickets > 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(Thread.currentThread().getName() + " : " + sTickets--);
        }
    }
}
