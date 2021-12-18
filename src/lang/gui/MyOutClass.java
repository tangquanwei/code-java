package lang.gui;

public class MyOutClass {
    private static int x;

    /**
     * InnerMyOutClass
     */
    public class InnerMyOutClass {
        int y=10;
        void go() {
            x = 100;
            System.out.println(x);
        }

    }
    public static void main(String[] args) {
        var outer=new MyOutClass(); //new outer
        MyOutClass.InnerMyOutClass inner=outer.new InnerMyOutClass(); //new inner
        inner.go();
        System.out.println(x);

    }
}
