package lang.net;

import java.io.*;
import java.net.*;

public class DayAdviceServer {
    String[] adviceList = { "人生的出场顺序很重要，我来得晚一点，没陪你朝朝暮暮，但等得久一点，愿陪你共度余生。",
            "哪怕是一只萤火虫喜欢上月亮，它也会想把自己所有的光都给它。跟喜欢的人多强大没关系，这是跳动不止的心意。", "其实，我有很多愿望，但是，唯独和你在一起，才是我漫漫余生中，那斩钉截铁的梦想。",
            "我想给你:时常的惦记，温柔的语气，无理由的偏爱，而且每天都想说的明天见。", "遇见你的那一刻就是大爆炸的开始，每一个粒子都离开我朝你飞奔而去，在那个最小的瞬间之后，宇宙才真正诞生。",
            "人生不如意的是十有八九，而你就是一二三四五六七。", "番茄和西红柿，土豆和马铃薯，我喜欢的人和你。", "凌晨四点钟，我看见海棠花未眠，总觉得这时你应该在我身边。",
            "你无法做一个人人喜欢的橘子，别人爱吃苹果香蕉，那不是你的错。", "以一灯传诸灯，终至万灯皆明。", "愿所有的后会有期，都是它日的别来无恙。", "孤独不是一种脾性，而是一种无奈。",
            "总归要过好自己的人生的。", "轻履者行远。", "能修净素颜，必有如水心。", "谢谢你，成为我前进的理由。", "风筝是因为束缚，才能飞得高。", "白昼之光，岂知夜色之深。",
            "生活不是你活过的样子，而是你记住的样子。" };

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242); // tcp端口
            try (serverSocket) {
                while (true) {
                    Socket sock = serverSocket.accept();
                    PrintWriter writer = new PrintWriter(sock.getOutputStream());
                    String advice = getAdvice();
                    writer.println(advice);
                    writer.close();
                    System.out.println(advice);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        var das = new DayAdviceServer();
        das.go();
    }
}
