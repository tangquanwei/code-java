package lang.io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * File表示一个文件或一个文件夹 在java.io包下
 */
public class TestFile {
    // 构造一个File对象，并不会导致任何磁盘操作
    // 文件夹
    File floder = new File("D:\\workspaceFolder\\CODE_JAVA");
    // 文件
    File file = new File("D:\\workspaceFolder\\CODE_JAVA\\a.txt");

    @Test
    public void testGet() {
        // 一种是getPath()，返回构造方法传入的路径，
        // 一种是getAbsolutePath()，返回绝对路径，
        // 一种是getCanonicalPath，
        System.out.println(file);
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        for (var i : floder.listFiles()) {

            System.out.println(i);
        }
        for (var i : floder.listRoots()) {

            System.out.println(i);
        }

    }
}
