package lang.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * BufferedInputStream
 * 
 * BufferedOutputStream
 * 
 * BufferedReader
 * 
 * BufferedWriter
 * 
 * 内部提供缓存区,加快速度
 */
public class TestBufferedIO {
    @Test
    public void testCopy() {
        // 1.定义文件
        File file = new File("D:\\workspaceFolder\\CODE_JAVA\\猫咪.png");
        File file2 = new File("D:\\workspaceFolder\\CODE_JAVA\\猫咪3.png");

        // 2.声明节点流
        FileInputStream in = null;
        FileOutputStream out = null;

        // 3.声明处理流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 4.定义节点流
            in = new FileInputStream(file);
            out = new FileOutputStream(file2);

            // 5.定义处理流
            bis = new BufferedInputStream(in);
            bos = new BufferedOutputStream(out);

            // 6.执行主要操作
            byte[] buf = new byte[10];
            int len;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {// 先关闭外层再关闭内层
                 // 关闭外层流的时候也会关闭内层流
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
