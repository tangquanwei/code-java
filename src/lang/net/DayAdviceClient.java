package lang.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayAdviceClient {
    public void go() {
        try {
            Socket sock = new Socket("39.99.42.127", 8080);
            InputStreamReader streamRader = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(streamRader);
            String advice = reader.readLine();
            System.out.println("Today: " + advice);
            reader.close();
            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var client = new DayAdviceClient();
        client.go();
    }
}
