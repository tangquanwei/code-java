package lang.compare;

/**
 * 实现Comparable, 排序
 */
public class Goods implements Comparable<Goods> {
    private int price;

    /**
     * @param price
     */
    public Goods(int price) {
        this.price = price;
    }

    private int dur;

    /**
     * @param price
     * @param dur
     */
    public Goods(int price, int dur) {
        this.price = price;
        this.setDur(dur);
    }

    /**
     * @return the dur
     */
    public int getDur() {
        return dur;
    }

    /**
     * @param dur the dur to set
     */
    public void setDur(int dur) {
        this.dur = dur;
    }

    @Override
    public int compareTo(Goods o) {
        return price - o.price;
    }

    @Override
    public String toString() {
        return "(" + price + "," + dur + ")";
    }
}
