package lang.thread;

/**
 * 生产者->店员->消费者 问题
 * 
 * 分析:
 * 
 * 是否是多线程问题: 是
 * 
 * 是否有共享数据: 有
 * 
 * 如何解决线程安全: 同步(3)
 * 
 * 是否涉及线程通信: 是
 */
public class Product {
    public static void main(String[] args) {
        var clerk = new Clerk();
        var t1 = new Thread(new Producer(clerk), "Producer");
        var t2 = new Thread(new Consumer(clerk), "Consumer");
        t2.start();
        t1.start();
    }

}

class Clerk {
    private int productNumber = 0;

    public void produceProduct() {
        synchronized (Clerk.class) {
            if (productNumber < 5) {
                System.out.println(Thread.currentThread().getName() + ":开始生产第" + ++productNumber + "个产品");
            } else {
                try {
                    Clerk.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consumeProduct() {
        synchronized (Clerk.class) {
            if (productNumber > 0) {
                System.out.println(Thread.currentThread().getName() + ":开始消费第" + productNumber-- + "个产品");
            } else {
                try {
                    Clerk.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        synchronized (Clerk.class) {
            System.out.println(Thread.currentThread().getName() + ":Pruduce");
            while (true) {
                Clerk.class.notify();
                clerk.produceProduct();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        synchronized (Clerk.class) {
            System.out.println(Thread.currentThread().getName() + ":Consume");
            while (true) {
                Clerk.class.notify();
                clerk.consumeProduct();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
