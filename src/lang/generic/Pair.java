package lang.generic;

import org.junit.Test;

import java.io.Serializable;


/**
 * 泛型类
 * 
 * 原始类型T会被一个限定类型替换(最前面那个 Comparable & Serializable 就是Comparable, 如果是
 * Serializable & Comparable 的话就会被 Serializable 替代, 而编译器会在必要时向 Comparable
 * 插入强制类型转换, 所以应该将没有方法的接口放在限定列表的末尾), 如果没有给定限定就会被Object替代
 * 
 * Java泛型转换的事实:
 * 
 * 1.虚拟机中没有泛型只有普通的类和方法
 * 
 * 2.所有的类型参数都会被替换为他们的限定类型
 * 
 * 3.会合成桥方法来保持多态
 * 
 * 4.为保持类型安全,必要时会插入强制类型转换
 * 
 * 限制
 * 
 * 1.不能用基本类型实例化参数类型
 * 
 * 2.运行时类型查询只适用于原始类型(非泛型类型 Piar而不是Pair<String,String>)
 * 
 * 3.不能创建参数化类型的数组(不能new Pair<String>[10] 可以声明 Pair<String>[])
 * 可以声明通配类型数组,然后强制类型转换: var table =(Pair<String>) new Pair<?>[10];
 * 
 * 4.
 */
public class Pair<T extends Comparable & Serializable, U extends Comparable & Serializable>
        implements Comparable<Pair>, Serializable {
    public T first;
    public U second;

    Pair(T f, U s) {
        first = f;
        second = s;
    }

    /**
     * 泛型方法
     * 
     * 可以在泛型类中定义也可以在普通类中定义
     * 
     * @return Pair<U, T>
     */
    public Pair<U, T> reverse() {
        return new Pair<U, T>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public int compareTo(Pair o) {
        return first.compareTo(o.first) + second.compareTo(o.second);
    }

    public static void main(String[] args) {
        ArrayAlg.testGenericArray();
    }

    @Test
    public void genericPairTest() {
        var p1 = new Pair<Integer, Integer>(1, 2);
        System.out.println(p1);
        var p2 = p1.reverse();
        System.out.println(p2);

        var p3 = new Pair<String, String>("Tang", "Quanwei");
        System.out.println(p3);
        System.out.println(p3.reverse());

        var p4 = new Pair<Integer, String>(100, "quanwei");
        System.out.println(p4);
        System.out.println(p4.reverse());
    }
}

class ArrayAlg {
    // ArrayAlg.<Integer>getMid(21231, 14124, 51351, 523, 12412);
    public static <T> T getMid(T... arr) {
        return arr[arr.length / 2];
    }

    /**
     * 用Comparable限制T的类型
     * 
     * 用extends表示T为限制类型的子类型
     * 
     * 用&分隔限制类型
     * 
     * @param <T>
     * @param arr
     * @return <T>
     */
    public static <T extends Comparable & Serializable> T min(T[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        T min = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (min.compareTo(arr[i]) > 0)
                min = arr[i];
        }
        return min;
    }

    public static void testGenericArray() {
        var table =new Single<?>[10];
        table[0]=new Single<String>("quanwer");
        table[1]=new Single<Integer>(1000);
        System.out.println(table[0]);
        System.out.println(table[1]);
    }

}

class Single<T> {
    public T data;
    public Single(T u) {
        data=u;
    }
    @Override
    public String toString() {
        return ": "+data;
    }
}