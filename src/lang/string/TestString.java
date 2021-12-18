package lang.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.*;

/**
 * TestString
 * 
 * 可以和八种基本数据类型做运算
 */
public class TestString {

    public static void main(String[] args) {

    }

    @Test
    public void testStringJoint() {
        // 字面量定义,s1指向方法区中的静态常量池
        String s1 = "Quanwei";
        String s2 = "Quanwei";
        // s2->堆空间地址值
        String s3 = new String("Quanwei");
        System.out.println("s1 == s2: " + (s1 == s2)); // true
        System.out.println("s1 == s3: " + (s1 == s3)); // false
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));// true
        System.out.println("s1.equals(s3): " + (s1.equals(s3)));// true

        String s4 = "TangQuanwei";
        String s5 = "Tang" + "Quanwei"; // 常量与常量拼接在静态常量池
        System.out.println("s4 == s5: " + (s4 == s5)); // true
        String s6 = "Tang" + s1; // 常量与引用拼接->堆空间地址值
        System.out.println("s4 == s6: " + (s4 == s6)); // false
    }

    @Test
    public void testToCharArray() {
        String s1 = "Quanwei";
        char[] charArray = s1.toCharArray();
        System.out.println(Arrays.toString(charArray));

        String s2 = "唐权威";
        char[] charArray2 = s2.toCharArray();
        System.out.println(Arrays.toString(charArray2));

    }

    @Test
    public void testGetBytes() {
        String s1 = "Quanwei";
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String s2 = "唐权威";
        byte[] bytes2 = s2.getBytes();// 默认utf-8
        System.out.println(Arrays.toString(bytes2));

        try {
            byte[] bytes3 = s2.getBytes("gbk");
            System.out.println(Arrays.toString(bytes3));

            byte[] bytes4 = s2.getBytes("utf-8");
            System.out.println(Arrays.toString(bytes4));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}