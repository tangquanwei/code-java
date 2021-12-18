package lang.thread;
// 线程安全版单例
public class TestBank {

}

class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;
    // 方法一:
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}