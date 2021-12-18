package lang.reflection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class NewObj {
    // 创建对象的方法
    public static void main(String[] args) {
        // 1.静态编码&编译 直接new调用构造函数
        NewObj ref = new NewObj();
        A a = ref.new A();
        a.hello();

        // 2.克隆
        B b1 = ref.new B();
        b1.hello();
        try {
            // b2是b1的克隆没有调用构造函数
            // b1, b2内容一样, 但在内存里面是两个副本
            B b2 = (B) b1.clone();
            b2.hello();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 3.序列化
        C c1 = ref.new C();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.data"))) {
            out.writeObject(c1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("obj.data"))) {
            C c2 = (C) in.readObject();
            c2.hello();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 4.反射
            Object o1=Class.forName("A").getDeclaredConstructor().newInstance();
            Method m=Class.forName("A").getMethod("hello");
            m.invoke(o1);
            A a1=(A) o1;
            a1.hello();
            
            A a2=(A) Class.forName("A").getDeclaredConstructor().newInstance();
            a2.hello();
            // 5.反射
            Constructor<A> ctor=A.class.getConstructor();
            A a3=ctor.newInstance();
            a3.hello();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class A {
        // 1.静态编码&编译
        public void hello() {
            System.out.println("Hello A for " + this.getClass().getName());
        }
    }

    public class B implements Cloneable {
        // 2.克隆
        // ? 深克隆 浅克隆
        public void hello() {
            System.out.println("Hello B for " + this.getClass().getName());
        }

        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public class C implements Serializable {
        public void hello() {
            System.out.println("Hello C for " + this.getClass().getName());
        }
    }
}
