package lang.net;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class TCP {

    public void clientResive() {
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // get from server
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip, 8899);
            inputStream = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len;
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }

            System.out.println(LocalDateTime.now() + " get from server: " + byteArrayOutputStream);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null)
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void clientSend() {
        Socket socket = null;
        InetAddress ip;
        OutputStream outputStream = null;

        try {
            ip = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip, 8899);
            // send to server
            outputStream = socket.getOutputStream();
            outputStream.write("唐权威 TangQuanwei".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void serverRevive() {
        ServerSocket server = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            server = new ServerSocket(8899);
            accept = server.accept();
            // client input
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            // 控制台输出
            System.out.println(LocalDateTime.now() + " get from client: " + byteArrayOutputStream);

            // 保存到本地
            fileOutputStream = new FileOutputStream(new File("D:\\workspaceFolder\\CODE_JAVA\\lang\\net\\file"));
            fileOutputStream.write(byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null)
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (accept != null)
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (server != null)
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void serverSend() {
        ServerSocket server = null;
        Socket accept = null;
        OutputStream outputStream = null;
        try {
            server = new ServerSocket(8899);
            accept = server.accept();
            // server output
            outputStream = accept.getOutputStream();
            outputStream.write("接收成功".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            if (accept != null)
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (server != null)
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        TCP tcp = new TCP();
        new Thread(() -> {
            tcp.serverSend(); // 先启动服务器
        }).start();
        // new Thread(() -> {
        //     tcp.clientResive();
        // }).start();
        new Thread(() -> {
            tcp.clientResive();
        }).start();
        // new Thread(() -> {
        //     tcp.clientSend();
        // }).start();
    }
}
