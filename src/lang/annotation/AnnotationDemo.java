package lang.annotation;

/**
 * @author Quanwei
 * java提供了5个基本的注解，分别是
 * 
 * 1.@Override
 * 
 * 2.@Deprecated
 * 
 * 3.@SuppressWarnings
 * 
 * 4.@SafeVarargs
 * 
 * 5.@FunctionalInterface
 */
public class AnnotationDemo {
    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Deprecated
    public void show() {
        System.out.println("被弃用");
    }

    public void show1() {
        System.out.println("取代show");
    }
    @SuppressWarnings("all")
    public void show3(){
        System.out.println("压制警告");
    }

    public static void main(String[] args) {
        AnnotationDemo ad = new AnnotationDemo();
        System.out.println(ad);
        ad.show();
        ad.show1();
    }
}
