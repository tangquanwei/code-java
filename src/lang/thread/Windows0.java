package lang.thread;
/**
 * 多线程操作共享数据,为保证线程安全需要给线程加上一把锁(同步监视器).
 * 
 * 操作同步代码时,只允许一个线程参与其他线程等待,相当于单线程
 * 
 * 方式一: 同步代码块
 * 
 * 方式二: 同步方法
 * 
 */
public class Windows0 implements Runnable {
    private int tickets = 50;//共享数据

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + tickets--);
            } else
                break;
        }
    }
}
