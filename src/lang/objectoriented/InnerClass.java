package lang.objectoriented;

public class InnerClass {
    /**
     * Inner
     */
    public class Inner {
        public void go() {
            System.out.println("Inner.go");
        }

        public static void main() {
            InnerClass outer = new InnerClass();
            Inner inner = outer.new Inner();
            outer.go();
            inner.go();

        }
    }

    public void go() {
        System.out.println("Outer.go");
        class MInner {

            public void go() {
                System.out.println("MInner.go");
            }
        }
        new MInner().go();
        this.go();
    }

    public static void main(String[] args) {
        InnerClass outer=new InnerClass();
        // Inner inner=outer.new Inner();
        outer.go();
        Inner.main();
    }
}
