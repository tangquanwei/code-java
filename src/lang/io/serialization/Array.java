package lang.io.serialization;

import java.io.*;
import java.util.ArrayList;

import org.junit.Test;

public class Array {
    ArrayList<Obj> arrayList = new ArrayList<Obj>();
    File file = new File("D:\\workspaceFolder\\CODE_JAVA\\lang\\serialization\\MyGame.ser");

    public static void main(String[] args) {
        Array array = new Array();
        // array.test();
        // array.write();
        array.read();
        for (var i : array.arrayList) {
            System.out.println(i);
        }
    }

    @Test
    public void test() {
        arrayList.add(new Obj("name", 18));
        arrayList.add(new Obj("Quanwei", 18));
        arrayList.add(new Obj("nagh", 18));
        arrayList.add(new Obj("Tang", 18));
        arrayList.add(new Obj("dnau", 18));
    }

    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object readObject = ois.readObject();
            if (readObject instanceof ArrayList)
                arrayList = (ArrayList) readObject;
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Obj implements Serializable {
    private String name;
    private int id;

    /**
     * @param name
     * @param id
     */
    public Obj(String name, int id) {
        this.setName(name);
        this.setId(id);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     */
    public Obj() {
    }

    @Override
    public String toString() {
        return "(" + name + "," + id + ")";
    }
}
