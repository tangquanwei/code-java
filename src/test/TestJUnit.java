package test;

import org.junit.Test;

public class TestJUnit {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println("quanwei");
        }
    }

    public void setUp() {
        System.out.println("开始测试");
    }

    public void finish() {
        System.out.println("结束测试");
    }

    @Test
    public void test() {
        for (int i = 0; i < 6; i++) {
            System.out.println("quanwei");
        }
    }
}