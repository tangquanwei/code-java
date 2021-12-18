package skill.sugar;

public interface MyInterface {// 接口没有ctor,没有main方法(不可运行),没有protected的方法
    // 默认方法 java7
    // 0.default关键字表示接口的默认方法,
    // 1.接口的默认方法不能重写Object里的方法
    // 2.实现类可以继承/重写父接口的默认方法
    // 3.接口可以继承/重写父接口的默认方法
    // 4.若父类父接口都有默认方法,子类继承父类的默认方法
    // 5.子类继承了两个接口(有相同默认方法),则必须重写这个default方法
    public default void defaultMethod() {
        System.out.println("This is the *default* method of interface SS, \nwhich is implemented in class "
                + this.getClass().getName());
        privateStaticMethod();
        privateMethod();
    }

    // 静态方法 java8
    // 只属于接口, 不可被继承
    public static void staticMethod() {
        System.out.println("This is the *static* method of interface SS");
        privateStaticMethod();

    }

    // 私有方法 java9
    // 只属于接口, 不可被继承, 不能在接口外被直接调用 use locally
    // 静态私有方法可以被默认方法调用
    private void privateMethod() {
        System.out.println("This is the *private* method of interface SS");

    }

    private static void privateStaticMethod() {
        System.out.println("This is the *private static* method of interface SS");

    }

}
