package lang.objectoriented;

public class Interface {

    public static void main(String[] args) {
        /**
         * 接口的使用
         * 
         * 1.多态性
         * 
         * 2.定义了一种规范
         * 
         * 3.表示: 能做...
         */
        Computer computer = new Computer();
        // 非匿名实现类的非匿名对象
        Fox fox = new Fox();
        computer.transferData(fox);
        // 匿名实现类匿名对象
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("Start");
            }

            @Override
            public void end() {
                System.out.println("End");
            }
        });

        var usb = new USB() {
            @Override
            public void start() {
                System.out.println("Start");
            }

            @Override
            public void end() {
                System.out.println("End");
            }
        };
        USB.staticMethod();
        usb.defaultMethod();
    }
}

/**
 * 接口中可以定义
 * 
 * 1.全局常量 public static final
 * 
 * 2.抽象方法 public abstruct
 * 
 * 3.静态方法 public static
 * 
 * 4.默认方法 public default
 */
interface USB {
    public static final int LENGTH = 2;
    public static final int WIDTH = 1;

    public abstract void start();

    public abstract void end();

    public static void staticMethod() {
        System.out.println("Static Method");
    }

    public default void defaultMethod() {
        System.out.println("Default Method");
    }

}

/**
 * Fox
 */
class Fox implements USB {
    @Override
    public void start() {
        System.out.println("Fox Start");
    }

    @Override
    public void end() {
        System.out.println("Fox End");
    }

}

/**
 * TestInterface
 */
class Computer {

    public void transferData(USB usb) {
        usb.start();
        System.out.println("Computer Transfer Data");
        usb.end();
    }

}