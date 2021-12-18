package lang.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

/**
 * 1.网络编程的两个主要问题 1)如何定位网络上的一台或多态主机,定位主机上的特定应用(IPhe端口) 2)找到主机后如何高效可靠的传输数据(TCP/IP)
 * 
 * 本地回环地址: (hostAddress):127.0.0.1
 * 
 * 主机名: (hostName):localhost
 * 
 * 局域网地址: 192.168.~
 * 
 * 端口号: 运行的程序
 * 
 * Sockst = ip + 端口号
 * 
 * TCP 可靠, 大量(三次握手, 四次挥手)
 * 
 * UDP 快速
 */
public class Net {

    @Test
    public void testIp() {
        try {
            InetAddress Aliyun = InetAddress.getByName("39.99.42.127");
            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            boolean reachable = localHost.isReachable(10);
            System.out.println(reachable);
            System.out.println(localHost);
            System.out.println(Aliyun);
            String canonicalHostName = Aliyun.getCanonicalHostName();
            String hostName = Aliyun.getHostName();
            System.out.println(hostName);
            System.out.println(canonicalHostName);
            System.out.println(loopbackAddress);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收端
     */
    @Test
    public void UDPReciver() {
        DatagramSocket server = null;
        try {
            server = new DatagramSocket(8900);
            byte[] buf = new byte[1024];// <=8K
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
            System.out.println("waiting...");
            while (true) {
                server.receive(datagramPacket);
                String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(datagramPacket.getAddress() + ":" + datagramPacket.getPort() + "send: " + string);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null)
                server.close();
        }

    }

    @Test
    public void UDPSender() {
        DatagramSocket client = null;
        try {
            client = new DatagramSocket();
            String str = "hello Quanwei";
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length,
                    InetAddress.getLocalHost(), 8900);
            System.out.println("start send...");
            client.send(datagramPacket);
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null)
                client.close();
        }
    }

    public static void main(String[] args) {
        Net net = new Net();
        new Thread(() -> {
            while (true) {
                net.UDPSender();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {

            net.UDPReciver();

        }).start();

    }
}
