package lang.compare;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * JAVA对象一般不能使用>或<比较大小
 * 
 * 使用接口:
 * 
 * 1.Comparable
 * 
 * 2.Comparator
 * 
 */
public class Compare {
    /**
     * 1.String,包装类等实现了Comparable接口,重写了compareTo()方法 2.重写compareTo()的规范: >this大于obj
     * 返回正整数 >this小于obj 返回负整数 >this等于obj 返回0
     */
    @Test
    public void testComparable() {
        Goods[] goods = new Goods[] { new Goods(3), new Goods(2), new Goods(0) };
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void testComparator() {
        Goods[] items = new Goods[] { new Goods(321), new Goods(45), new Goods(36), new Goods(12315), new Goods(375),
                new Goods(35) };
        // Arrays.sort(items, new Comparator<Goods>() {
        //     @Override
        //     public int compare(Goods o1, Goods o2) {
        //         return -o1.compareTo(o2);
        //     }
        // });
        Arrays.sort(items, (o1,o2)->{
            return -o1.compareTo(o2);
        });

        System.out.println(Arrays.toString(items));
    }

}

class Cmp implements Comparator<Goods> {

    @Override
    public int compare(Goods o1, Goods o2) {
        return -o1.compareTo(o2);
    }

}
