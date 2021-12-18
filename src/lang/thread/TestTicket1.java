package lang.thread;


public class TestTicket1 {
    public static void main(String[] args) {
        var w1=new Thread(new Windows3(),"w1");
        var w2=new Thread(new Windows3(),"w2");
        var w3=new Thread(new Windows3(),"w3");
        w1.start();
        w2.start();
        w3.start();
    }
}
