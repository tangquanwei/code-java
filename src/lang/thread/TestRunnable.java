package lang.thread;
/**
 * 实现多线程
 * 
 * 1.implements Runnable
 * 
 * 2.重写run方法
 * 
 * 3.new Thread(new MyRunnable) 将实现了Runnable的对象以参数形式传入
 * 
 * 4.Thread.start()
 * 
 * 优点:
 * 
 * 1.没有多继承限制
 * 
 * 2.更适合多线程有共享数据的情况
 */
public class TestRunnable {
    private int n=100;
    /**
     * Even
     */
    class Even implements Runnable{//1
        @Override
        public void run() {//2
            for(int i=0;i<=n;++i){
                if(i%2==0)
                System.out.println(i);
            }
        }
    }
    /**
     * Odd
     */
    class Odd implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <= n; i++) {
                if(i%2!=0)
                System.out.println(i);
            }
        }

        
    }
    public static void main(String[] args) {
        // var t=new TestRunnable();
        // var thread1=new Thread(t.new Odd());//3
        // var thread2=new Thread(t.new Even());
        // thread1.start();//4
        // System.out.println("ssss");
        // thread2.start();

        new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if(i%2==0){
                        System.out.println(i);
                    }                        
                }
            }
        };
    }
}
