package lang.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable {
    String name;
    String id;

    Serialization() {
    }

    Serialization(String n, String i) {
        name = n;
        id = i;
    }

    void showAll() {
        System.out.println(name + "\n" + id);
    }

    public static void main(String[] args) {
        var ser = new Serialization();
        ser.write();
        ser.read();
    }

    void write() {
        var ser0 = new Serialization("Tang", "20203206220");
        var ser1 = new Serialization("Quanwei", "20203206222");
        try {
            FileOutputStream fos = new FileOutputStream("D:\\workspaceFolder\\CODE_JAVA\\Serialization\\MyGame.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos); // 连接
            oos.writeObject(ser0);
            oos.writeObject(ser1);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void read() {
        try {
            FileInputStream fis = new FileInputStream("D:\\workspaceFolder\\CODE_JAVA\\Serialization\\MyGame.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj0 = ois.readObject();
            var ser0 = (Serialization) obj0;
            var ser1 = (Serialization) ois.readObject();
            ois.close();
            ser0.showAll();
            ser1.showAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
