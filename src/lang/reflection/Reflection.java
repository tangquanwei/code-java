package lang.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.junit.Test;

/**
 * 具有能够分析类能力的程序称为反射
 * 
 * 在运行时检查对象
 * 
 * 实现泛型数组操作代码
 * 
 * Method对象(C++函数指针)
 * 
 * Class类保存运行时类型标识
 */
public class Reflection extends Cls implements Interf {
    private int a;
    protected double b;
    public boolean c;

    protected Reflection reflection = new Reflection();

    /**
     * @param a
     * @param b
     * @param c
     */
    private Reflection(int a, double b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * 
     */
    public Reflection() {
    }

    public static void main(String[] args) {

    }

    private void pM() {
        System.out.println("private method in Reflection");
    }

    public void pM(int i) {
        System.out.println("public method in Reflection  : " + i);
    }

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void say() {
        System.out.println("say() in Reflection");
    }

    @Test
    public void testClass() {
        // getClass()
        Reflection ref = new Reflection();
        Class<? extends Reflection> c1 = ref.getClass();
        System.out.println(c1.getName());// lang.reflection.Reflection
        System.out.println(c1.getSimpleName());// Reflection
        System.out.println(c1.getCanonicalName());// lang.reflection.Reflection

        // forName()
        try {
            Class<?> c2 = Class.forName("lang.reflection.Reflection");
            System.out.println(c2.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // getConstructor
        try {
            Constructor<Reflection> ctor = Reflection.class.getConstructor();
            Reflection newInstance = ctor.newInstance();
            System.out.println(newInstance);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet() {
        System.out.println("--------------getFields()-------------------------");
        // getFields() 包括父类字段
        Field[] fields = Reflection.class.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--------------getDeclaredFields()-------------------------");

        // getDeclaredFields() // 对应类的全部字段
        Field[] declaredFields = Reflection.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        System.out.println("---------------getMethods()------------------------");

        // 返回所有公共方法包括父类方法和Object类的方法
        Method[] methods = Reflection.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("---------------getDeclaredMethods()------------------------");

        // 返回这个类或接口的全部方法不包括继承到的方法
        Method[] declaredMethods = Reflection.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println("---------------getConstructors()------------------------");

        // 公共
        Constructor<?>[] constructors = Reflection.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?>[] constructors2 = super.getClass().getConstructors();
        for (Constructor<?> constructor : constructors2) {
            System.out.println(constructor);
        }

        System.out.println("---------------getDeclaredConstructors()------------------------");

        // 全部
        Constructor<?>[] declaredConstructors = Reflection.class.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Field[] declaredFields = this.getClass().getDeclaredFields();
        Constructor<?>[] declaredConstructors = this.getClass().getDeclaredConstructors();
        Method[] declaredMethods = this.getClass().getDeclaredMethods();
        Annotation[] declaredAnnotations = this.getClass().getDeclaredAnnotations();

        sb.append("Fields:\n");
        sb.append(Arrays.toString(declaredFields));
        sb.append("\nCtors:\n");
        sb.append(Arrays.toString(declaredConstructors));
        sb.append("\nMethods:\n");
        sb.append(Arrays.toString(declaredMethods));
        sb.append("\nAnnotations:\n");
        sb.append(Arrays.toString(declaredAnnotations));

        return sb.toString();
    }

    @Test
    public void testToString() {
        System.out.println(reflection.toString());
    }

    public static Object copyOf(Object a, int newLength) {
        Class<? extends Object> c1 = a.getClass();
        if (!c1.isArray())
            return null;
        Class<?> componentType = c1.getComponentType();
        int length = Array.getLength(a);
        Object array = Array.newInstance(componentType, length);
        System.arraycopy(a, 0, array, 0, Math.min(length, newLength));
        return array;
    }

    @Test
    public void testCopyOf() {
        String[] a = { "1", "3", " 5" };
        a = (String[]) Reflection.copyOf(a, 4);
        System.out.println(Arrays.toString(a));

        int[] b = { 1, 2, 3, 4, 5 };
        int[] c = (int[]) Reflection.copyOf(b, 4);
        System.out.println(Arrays.toString(c));
    }

    @Test
    public void testInvoke() {
        Class<?> c1 = Reflection.class;
        System.out.println(c1.getName());
        try {
            Method method = c1.getMethod("pM", int.class);
            method.invoke(c1.getConstructor().newInstance(), 1);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
