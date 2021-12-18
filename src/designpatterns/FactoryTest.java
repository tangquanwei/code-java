package designpatterns;

/**
 * 实现了创建者与调用者的分离，即将创建对象的具体过程屏蔽隔离 起来，达到提高灵活性的目的
 * 
 * OCP（开闭原则，Open-Closed Principle） 一个软件的实体应当对扩展开放，对修改关闭。
 * 
 * DIP（依赖倒转原则，Dependence Inversion Principle） 要针对接口编程，不要针对实现编程。
 * 
 * 如果 A 中关联 B，那么尽量使得 B 实现某个接口，然后 A 与接口发生关系，不与 B 实现类发生关联关系。
 * 依赖倒置的潜台词是：面向抽象编程，解耦调用和被调用者。
 * 
 * LOD（迪米特法则，Law Of Demeter） 只与你直接的朋友通信，而避免和陌生人通信。
 * 要求尽量的封装，尽量的独立，尽量的使用低级别的访问修饰符。这是封装 特性的典型体现。
 */

public class FactoryTest {
    public static void main(String[] args) {
        // 通过工厂类调用方法
        new AudiFactory().getCar().run();
        new BYDFactory().getCar().run();
    }

}

// 1.创建共同接口
interface Car {
    void run();
}

// 2.创建实现类
class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Audi is Running");
    }
}

class BYD implements Car {
    @Override
    public void run() {
        System.out.println("BYD is Running");
    }
}

// 3.创建工厂接口
interface Factory {
    Car getCar();
}

// 4.实现工厂接口
class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}

class BYDFactory implements Factory {
    @Override
    public Car getCar() {
        return new BYD();
    }
}
