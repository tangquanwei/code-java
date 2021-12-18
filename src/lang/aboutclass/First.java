package lang.aboutclass;

import java.util.Scanner;
/* *
 * Java语言支持的变量类型有：
 * 类变量：独立于方法之外的变量，用 static 修饰。
 * 实例变量：独立于方法之外的变量，不过没有 static 修饰。
 * 局部变量：类的方法中的变量。

 * Java语言提供了很多修饰符，主要分为以下两类：

 * 访问修饰符: 
 * default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
 * private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * public : 对所有类可见。使用对象：类、接口、变量、方法
 * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * 父类中声明为 public 的方法在子类中也必须为 public。
 * 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private
 * 父类中声明为 private 的方法，不能够被继承

 * 非访问修饰符:
 * static 修饰符
 * 静态变量：
 * static 关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。
 * 静态方法：
 * static 关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。静态方法从参数列表得到数据，然后计算这些数据。

 * final 修饰符
 * final 变量:
 * final 表示"最后的、最终的"含义，变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值。
 * final 修饰符通常和 static 修饰符一起使用来创建类常量。
 * final 方法:
 * 父类中的 final 方法可以被子类继承，但是不能被子类重写。
 * final 类:
 * final 类不能被继承，没有类能够继承 final 类的任何特性。

 * abstract 修饰符
 * 抽象类：
 * 抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
 * 一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
 * 抽象类可以包含抽象方法和非抽象方法。
 * 抽象方法
 * 抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
 * 抽象方法不能被声明成 final 和 static。
 * 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
 * 如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。
 * 抽象方法的声明以分号结尾，例如：public abstract sample();。
 */

final class Second{

}


public class First {
    static int s_cnt = 0; // 类变量
    int cnt = 0;// 实例变量
    final int SIZE = 10; // const
    static String name = "Tang Quanwei";

    public void printArray(int[] array) {
        System.out.print(array);
    }

    public void addCnt() {
        ++s_cnt;
        ++cnt;
    }

    public void showCnt() {
        System.out.println(cnt);
    }

    public static void showName(boolean isOn) {
        if (isOn)
            System.out.println(name);
    }

    public static void convert() {
        /* 英制到公制 */
        int foot;
        int inch;// 两个整数的运算结果一定是整数
        Scanner in = new Scanner(System.in);// 惯用
        foot = in.nextInt();
        inch = in.nextInt();
        System.out.println((foot + inch / 12f) * 0.3048);
        in.close();
    }

    public static void main(String[] args) {
        // showName(true);
        // int age1 = 10;// 局部变量
        convert();
    }
}

