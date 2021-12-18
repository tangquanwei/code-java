package lang.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelif();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelif() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I eat " + food);

    }

    public void go() {
        System.out.println("go in Superman");
    }

}

// 代理类
class ProxyFactory {
    public static Object getProxyInstance(Object obj) {// onj 代理类对象

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

    }

}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method:代理类对象调用的方法,此方法也就作为了被代理类的方法
        Object invoke = method.invoke(obj, args);
        return invoke;
    }

}

/**
 * 动态代理
 * 
 * 运行时确定
 * 
 * 问题:
 * 
 * 1.如何根据内存里的代理类,动态的创建代理类及其对象
 * 
 * 2.当代理类对象调用方法是时, 如何动态的调用被代理类的方法
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 同样的实现接口 的代理类
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        proxyInstance.eat("麻辣烫");
        System.out.println(proxyInstance.getBelif());

        // try {
        //     SuperMan s=(SuperMan)proxyInstance;
        //     s.go();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }


    }
}
