package lang.objectoriented;

//声明类或接口所在的包
//每"."一次,代表一层文件目录
import java.util.Scanner;
//在源文件中显示的导入指定的类, 接口
//声明在包的声明和类的声明之间
//java.lang和同一包下可以省略

/**
 * class ObjectOriented JAVA面向对象3条主线:
 * 
 * 1.Java类及类的成员: 1.属性 2.方法 3.构造器 4.代码块 5.内部类
 * 
 * 2.面向对象的3大特征: 封装,继承,多态,(抽象)
 * 
 * 3.关键字 this,super,return... return 1.结束方法 2.返回值 3.其后不声明执行语句
 * 
 * 
 * 一.设计类 属性 = 成员变量 = field 方法 = 成员函数 = method
 * 
 * 多态
 * 
 * 父类引用不能调用子类特殊方法
 * 
 */
public class TestOOP {
    Scanner in = new Scanner(System.in);

    /* test */
    public static void main(String[] args) {
        Person p1 = new Woman();
        System.out.println(p1 instanceof Person);
        p1 = new Man();
        System.out.println(p1 instanceof Woman);
        Man p2=(Man) p1;
        System.out.println(!p2.isHandsome);
        Student.num=7;
    }
}
