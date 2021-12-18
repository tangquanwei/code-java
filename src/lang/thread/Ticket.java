package lang.thread;


public class Ticket {
    public static void main(String[] args) {
        var w = new Windows4();
        var w1 = new Thread(w, "w1");
        var w2 = new Thread(w, "w2");
        var w3 = new Thread(w, "w3");
        w2.setPriority(Thread.MAX_PRIORITY);
        w1.start();
        w2.start();
        w3.start();
    }

}
