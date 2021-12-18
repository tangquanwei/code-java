package lang.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * Java规定：
 * 
 * 必须捕获的异常，包括Exception及其子类，但不包括RuntimeException及其子类，这种类型的异常称为Checked Exception。
 * 
 * 不需要捕获的异常，包括Error及其子类，RuntimeException及其子类。
 * 
 * 分类
 * 
 * 1.Error
 * 
 * StackOverFlow, HeapOutOfMemory
 * 
 * 一般不编写代码处理
 * 
 * 2.Exception
 * 
 * >编译时异常cheaked
 * 
 * >>IOException
 * 
 * >运行时异常uncheaked
 * 
 * >>NullPointerException
 * 
 * 异常处理: 抓抛模型
 * 
 * 1."抛":在程序正常执行的时,一但出现异常,就抛出一个异常对象,其后代码不载执行
 * 
 * 1."抓":
 * 
 * >1)try-catch-finally
 * 
 * >>父类没有throws,子类异常必须try-catch
 * 
 * >2)throws(声明异常) >>throw(抛出异常)方法体内
 * 
 * finally抛出异常后，原来在catch中准备抛出的异常就“消失”了，因为只能抛出一个异常。没有被抛出的异常称为“被屏蔽”的异常（Suppressed Exception）
 */
public class TestException {
    public static void main(String[] args) {
        // try (Scanner in = new Scanner(System.in)) {
        //     int a = Integer.parseInt(in.next());
        //     System.out.println(a);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // try {
        //     m2();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
            new TestException().testFinally();
    }

    public static void m2() throws IOException {
        m1();
    }

    public static void m1() throws FileNotFoundException, IOException {
        File file = new File("Hello.txt");
        file.createNewFile();
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }

    public static void m3(int a, int b) throws RuntimeException {
        if (b > 0) {
            System.out.println(a / b);
        } else {
            throw new RuntimeException("除数不能为零");
        }

    }

    @Test
    public void testFinally(){
        try{
            int i=10/0;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                int b= 1/0;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
