package lang.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestByteStream {

    public void copyPng() {
        File file = new File("D:\\workspaceFolder\\CODE_JAVA\\猫咪.png");
        File fileB = new File("D:\\workspaceFolder\\CODE_JAVA\\猫咪2.png");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(fileB);

            int len;
            byte[] bbuf = new byte[10];
            while ((len = fileInputStream.read(bbuf)) != -1) {
                fileOutputStream.write(bbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void read() {
        File file = new File("D:\\workspaceFolder\\CODE_JAVA\\lang\\io\\TestByteStream.java");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new TestByteStream().copyPng();
    }

}
