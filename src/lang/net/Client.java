package lang.net;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 65535)) {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入:\n长方形的长, 宽\n或圆的半径\n或三角形的三条边长\n用空格隔开,按回车结束");
            String line = br.readLine();
            os.write(line.getBytes());
            byte[] b = new byte[66];
            is.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
