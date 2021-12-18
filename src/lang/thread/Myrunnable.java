package lang.thread;

public class Myrunnable implements Runnable{
    public void run(){
        go();
    }
    public void go(){
        doWork();
    }
    public void doWork(){
        System.out.println("hello Tang Quanwei !!!");
        System.out.println("Now thread in: "+Thread.currentThread().getName());
    }
    
}
