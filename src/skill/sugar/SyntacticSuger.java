package skill.sugar;

import static java.lang.System.out; //*静态导入 导入静态方法和静态变量`
import java.util.Locale;
import java.util.Scanner;

public class SyntacticSuger implements MyInterface {
    long numWith_ = 100_000_000L; // 数字间使用下划线

    public static void main(String[] args) {
        // var sc = new SyntacticSuger();
        // sc.pack("tang", "quanwei");
        // String[] s = { "zxc", "qdaf" };
        // sc.pack1(s);
        // sc.defaultMethod();
        // SS.staticMethod();

        // new SyntacticSuger().testSwitch();
        
    }

    void pack(String... args) {// 可变参数本质上是数组,优先级比定参低
        System.out.println(args.length);
        for (String string : args) {
            out.println(string); // *静态导入
        }
    }

    void pack1(String[] args) {
        System.out.println(args.length);
        for (String string : args) {
            out.println(string);
        }
    }

    void parallelException() {// 异常并列
        // try (FileInputStream fis=new FileInputStream("")) {// 要实现AutoCloseable接口
        // ObjectInputStream ois=new ObjectInputStream(fis);
        // } catch (IOException|SQLClientInfoException e) {
        // }

    }

    void testResourceBundle() {
        Locale myLocal = Locale.getDefault();
        System.out.println(myLocal);
    }

    void testSwitch() {
        int days = -1;
        try (var in = new Scanner(System.in);) {
            var month = in.next();
            switch (month) {// jdk12
            case "Jan", "Mar", "July", "Aug", "Oct", "Dec" -> days = 31;
            case "Apr", "June", "Sep", "Nov" -> days = 30;
            case "Feb" -> days = 28;
            default -> {
                System.out.println("输入有误");
                return;
            }
            }
        } catch (Exception e) {
        }
        System.out.println(days);

    }

    void testFunctionalInterface() {
        MyFunc func = () -> {
            System.out.println("go in MyFunc");
        };
        func.go();
    }
}

@FunctionalInterface
interface MyFunc {
    void go();
}
