package lang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方法四:使用线程池 经常创建和销毁,使用量大
 * 
 * 提前创建好多个线程,放入线程池,使用时直接获取 使用完放回池中,避免频繁创建和销毁,实现重复利用
 */
public class TestThreadPool {
    public static void main(String[] args) {
        // 1. 获取一个给定线程数目的线程池
        var service = Executors.newFixedThreadPool(8);// 并发线程数=内核数
        // 2.创建Runnable对象
        var work = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; ++i) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("execute Runnable");
                }
            }
        };
        var callWork=new Callable<String>(){
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 3; ++i) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("execute Callable");
                }
                return "Finish Callable";
            }
        };

        // 3.提交对象,并执行
        service.submit(work);
        service.submit(work);
        service.submit(work);
        service.submit(work);
        service.submit(work);
        service.submit(work);
        service.submit(work);
        Future<String> future = service.submit(callWork);
        Future<String> future1 = service.submit(work, "OK");
        try {
            System.out.println(future.get());
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 4.关闭服务,完成已提交的任务不再接受新任务
        service.shutdown();

    }

}
