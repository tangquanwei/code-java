package lang.net;

import java.net.URL;

/**
 * url https://www.bilibili.com/video/BV1Kb411W75N?p=629
 * 
 * <协议>//:<主机名>:<端口号>/<文件名/>#<片段名?><参数列表>
 */

public class MyUrl {
    public static void main(String[] args) {
        
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629");
            
            System.out.println(url.getAuthority());// www.bilibili.com
            System.out.println(url.getDefaultPort());// 443
            System.out.println(url.getFile());// /video/BV1Kb411W75N?p=629
            System.out.println(url.getPath());// /video/BV1Kb411W75N
            System.out.println(url.getProtocol());// https

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
