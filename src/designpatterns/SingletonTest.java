package designpatterns;
public class SingletonTest {
    public static void main(String[] args) {
        Singleton.instance.say();
        Singleton.a();
    }
}
class Singleton{
    static Singleton instance=new Singleton();
    private Singleton(){}
    void say(){
        System.out.println("say in Singleton");
    }
    static void a(){
        System.out.println("a in Singleton");
    }
}
