package lang.net;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(65535);) {
            while (true) {
                new Thread(() -> {
                    try (Socket socket = server.accept()) {
                        byte[] bytes = new byte[1024];
                        socket.getInputStream().read(bytes);
                        String[] datas = new String(bytes).split(" ");
                        double res;
                        switch (datas.length) {
                            case 1:
                                double r = Double.parseDouble(datas[0]);
                                res = Math.PI * r * r;
                                break;
                            case 2:
                                double m = Double.parseDouble(datas[0]);
                                double n = Double.parseDouble(datas[1]);
                                res = m * n;
                                break;
                            case 3:
                                double a = Double.parseDouble(datas[0]);
                                double b = Double.parseDouble(datas[1]);
                                double c = Double.parseDouble(datas[2]);
                                double p = (a + b + c) / 2;
                                res = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                                res = res > 0 ? res : -1;
                                break;
                            default:
                                res = 0;
                                break;
                        }
                        socket.getOutputStream().write(Double.valueOf(res).toString().getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
