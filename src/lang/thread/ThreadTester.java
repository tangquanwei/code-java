package lang.thread;

public class ThreadTester {
    public static void main(String[] args) {
        Runnable job = new Myrunnable();
        Thread myThread = new Thread(job);
        myThread.setName("hello");
        myThread.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("back in main");
        System.out.println("Now thread in: "+Thread.currentThread().getName());

    }

}