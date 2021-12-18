package lang.objectoriented;

/**
 * Singleton1
 * 单例模式
 * static 的应用
 */
public class Singleton1 {
    /* 1.定义静态私有实例 */
    private static Singleton1 instance = new Singleton1();

    /* 2.定义私有构造器 */
    private Singleton1() {
    }
    /* 3.定义公共静态方法返回实例 */
    public static Singleton1 getInstance() {
        return instance;
    }
    public void go(){
        System.out.println("Go in Singleton");
    }
    public static void main(String[] args) {
        var s=Singleton1.getInstance();
        s.go();
    }
}