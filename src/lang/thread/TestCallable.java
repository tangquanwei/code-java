package lang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方法3 实现Callable接口 特点 1)有返回值(泛型) 2)可以抛异常
 * 
 */
public class TestCallable {
    public static void main(String[] args) {
        // 3.创建实现类对象
        NumberThread numberThread = new NumberThread();
        // 4.用实现类对象创建FutureTask对象
        var futureTask = new FutureTask<NumberThread>(numberThread);
        // 5.用FutureTask对象创建线程
        var thread = new Thread(futureTask);
        thread.start();

        try {
            // 6.用FutureTask对象的get()方法获取返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //简写
        new Thread(new FutureTask<>(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                System.out.println("quanwei");
                System.out.println("quanwei");
                System.out.println("quanwei");
                System.out.println("quanwei");
                System.out.println("quanwei");
                return 0;
            }
        })).start();

    }
}

// 1.implements Callable
class NumberThread implements Callable {
    // 2.重写call()方法
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; ++i) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}