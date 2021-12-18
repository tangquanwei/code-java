package lang.thread;

/**
 * 大概率,线程1先拿到s2然后睡眠,随后线程2拿到s1,线程1醒来等待线程2释放s1,线程2等待线程1释放s2
 */
public class DeadLock {
    public static void main(String[] args) {
        var s1 = new StringBuffer();
        var s2 = new StringBuffer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (s1) {
                        s1.append("b");
                        s2.append("2");
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (s2) {
                        s1.append("d");
                        s2.append("4");
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();
    }
}
