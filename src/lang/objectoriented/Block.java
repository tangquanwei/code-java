package lang.objectoriented;

public class Block {
    String s1;
    static String s2;

    // 静态代码块 类加载时执行
    static {
        System.out.println("I am Static Block");
    }
    // 代码块 new对象时执行比ctor先执行
    {
        System.out.println("I am Non-Static block");
    }

    Block() {
        System.out.println("CTOR");
    }

    Block(String s) {
        this.s1 = s;
    }

    public static void main(String[] args) {
        Block.s2 = "1";
        new Block();
        new Block("s2");
    }
}
