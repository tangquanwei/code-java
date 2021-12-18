package lang.aboutclass;

class TestPoint {
    public static void main(String[] args) {
        Point p = new Point(123, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);
    }
}

// 定义一个Point类，有x、y两个变量，同时它是一个不变类
public record Point(int x, int y) {
    // Compact Constructor，它的目的是让我们编写检查逻辑 
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
}
/*
 * 相当于
 * 
 * public final class Point extends Record {
 * 
 * private final int x;
 * 
 * private final int y;
 * 
 * public Point(int x, int y) { this.x = x; this.y = y; }
 * 
 * public int x() { return this.x; }
 * 
 * public int y() { return this.y; }
 * 
 * public String toString() { return String.format("Point[x=%s, y=%s]", x, y); }
 * 
 * public boolean equals(Object o) { //... } public int hashCode() { //... } }
 */
