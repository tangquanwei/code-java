package lang.objectoriented;

public class Singleton2 {
    /* 1.声明私有静态实例并初始化为null */
    private static Singleton2 instance = null;

    /* 2.定义私有构造器 */
    private Singleton2() {
    }

    /* 3.定义公共静态方法,返回实例 */
    public static Singleton2 getInstance() {
        if (instance == null)
            instance = new Singleton2();
        return instance;
    }

    public void go() {
        System.out.println("Go in Singleton2");
    }

    public static void main(String[] args) {
        var s = Singleton2.getInstance();
        s.go();
    }
}
