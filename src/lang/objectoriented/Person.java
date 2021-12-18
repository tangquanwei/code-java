package lang.objectoriented;
//声明类或接口所在的包

//每"."一次,代表一层文件目录

/**
 * JavaBean是一种java语言写成的可重用组件 指符合下列标准的类: 1.类是公共的 2.有一个无参公共构造器
 * 3.有属性,及其对应的getter,setter
 * 
 */
public class Person {
    public static int num;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void say() {
        System.out.println("Person Say");
    }

    // 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同
    public void sayHi() {
        System.out.println("Hi Person Quanwei");
    }

    public void sayHi(String s) {
        System.out.println("Hi " + s);
    }

    public void sayHi(String... s) {
        System.out.println("String ...s");
    }
}
