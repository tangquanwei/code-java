package lang.string;

import org.junit.Test;


/**
 * String 不
 * 
 * StringBuffer 可变,同步安全,效率低
 * 
 * StringBuilder JDK5.0新增 可变,同步不安全,效率高
 *
 * 底层都用char[]存储
 */
public class TestStringBufferBuilder {
    @Test
    public void testStringBuilder() {
        var sb1 = new StringBuilder("Tang");
        var sb2 = new StringBuilder("c");
        System.out.println(sb1.capacity());
        System.out.println(sb1.length());
        sb1.ensureCapacity(4);
        System.out.println(sb1);
        System.out.println(sb2.capacity());
    }

}
