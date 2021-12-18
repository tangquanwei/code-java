package lang.objectoriented;

/**
 * Student
 */
class Student extends Person {
    private String id;
    private String major;

    public Student() {
    }

    public Student(String name, String id2, String major) {
        super(name);// 调用父类ctor
        this.id = id2;
        this.major = major;
    }

    /**
     * overriide/overwrite重写 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
     * 名称:子类中重写的方法,父类中被重写的方法 1.重写的方法名和形参列表与父类相同 2.访问权限不能变小 子类不能重写父类的private方法
     * 3.返回值类型 父类(void)->子类(void) 父类(A)->子类(A或A的子类) 4.重写方法抛出的异常类型不大于父类被重写的
     * 5.static方法不能被重写
     * 
     * overload重载
     */
    @Override
    public String toString() {
        // 调用父类方法
        return super.getName() + "\t" + id + "\t" + major;
    }

    public void say() {
        // 父类中有get和set方法,子类可以通过调用this.方法名访问父类的私有属性
        // 子类对象确实拥有父类对象中所有的属性和方法，但是父类对象中的私有属性和方法，子类是无法访问到的，只是拥有，但不能使用。就像有些东西你可能拥有，但是你并不能使用
    }
}

class Undergraduate extends Student {
    Undergraduate() {

    }
}
