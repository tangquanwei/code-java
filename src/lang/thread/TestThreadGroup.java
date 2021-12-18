package lang.thread;

public class TestThreadGroup {
    public static void main(String[] args) {
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup systenThreadGroup = mainThreadGroup.getParent();
        System.out.println("systenThreadGroup name = " + systenThreadGroup.getName());
        System.out.println("mainThreadGroup name = " + mainThreadGroup.getName());
    }
}
