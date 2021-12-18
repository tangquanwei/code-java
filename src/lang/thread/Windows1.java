package lang.thread;
/**
 * 同步代码块
 * 
 * synchronized(同步监视器){//同步监视器可用: 类.class(保证唯一)
 * 
 * //要同步的代码
 * 
 * }
 * 
 * 
 * 不需要synchronized的操作 JVM规范定义了几种原子操作：
 * 
 * 基本类型（long和double除外）赋值，例如：int n = m； 引用类型赋值，例如：List<String> list = anotherList。
 * 
 * long和double是64位数据，JVM没有明确规定64位赋值操作是不是一个原子操作，不过在x64平台的JVM是把long和double的赋值作为原子操作实现的
 * 
 * 单条原子操作不需要线程同步,多条需要
 */
public class Windows1 implements Runnable {
    private int tickets = 50;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (Windows1.class) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + tickets);
                    --tickets;
                } else
                    break;
            }
        }
    }

}
