package lang.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 内存的角度
 * 
 * 输入:外部数据->内存
 * 
 * 输出:内存->外部数据
 * 
 * 字节流(8bit): InputStream, OutPutStream
 * 
 * 字符流(16bit): Reader, Writer
 */
public class TestCharStream {
    // 1.File对象指明文件
    private final File file = new File("data.txt");

    public TestCharStream() {
    }

    public static void main(String[] args) {
        new TestCharStream().copyFile("data.txt", "file.txt");
    }

    @Test
    public void testFileReadWite() {
        TestCharStream testIO = new TestCharStream();
        testIO.Write("""
                public void Read() {
                    try {
                        FileReader fileReader = new FileReader(file);
                        int read;
                        while ((read = fileReader.read()) != -1)
                            System.out.print((char)read);
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                public void Write(String toBeWrite) {
                    try {
                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.append(toBeWrite);
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                """);
        testIO.Read();
    }

    /**
     * Read from file and print to console
     */
    public void Read() {
        // 2.Reader对象

        FileReader fileReader = null;
        try {
            // 3.读
            fileReader = new FileReader(file);// 读入的文件一定要存在
            int read;
            while ((read = fileReader.read()) != -1)
                System.out.print((char) read);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Write String to file
     * 
     * @param toBeWrite
     */
    public void Write(String toBeWrite) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("By_Quanwei\n");
            fileWriter.append(toBeWrite);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null)
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }

    /**
     * Copy fileA to fileB
     */
    public void copyFile(String fileA, String fileB) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(fileA);
            fileWriter = new FileWriter(fileB);
            int len;
            char[] cbuf = new char[10];
            while ((len = fileReader.read(cbuf)) != -1) {
                fileWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
