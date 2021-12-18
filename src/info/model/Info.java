package info.model;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Info implements Serializable {
    String name;
    String gender;
    String id;
    String score;
    public Integer[] birthday;// year, maonth, day
    String resume;

    public static void main(String[] args) {//!test here
        Integer[] b = { 2001, 10, 9 };
        var info0 = new Info("Quanwei", "男", "20203206222", "100", b, "I'm so rare and uncommon");
        Info.save(info0);
        try {
            FileInputStream fis = new FileInputStream("D:\\workspaceFolder\\CODE_JAVA\\InfoSystem\\Info.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Info info1 = Info.read(ois);
            info1.showAll();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Info() {
    }

    public Info(String name, String gender, String id, String score, Integer[] birthday, String resume) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.score = score;
        this.birthday = birthday;
        this.resume = resume;
    }

    public Info(Info info) {
        this.name = info.name;
        this.gender = info.gender;
        this.id = info.id;
        this.score = info.score;
        this.birthday = info.birthday;
        this.resume = info.resume;
    }

    public void showAll() {//test
        System.out.println("名字: " + name + "\n性别: " + gender + "\n编号: " + id + "\n成绩: " + score + "\n生日: " + birthday[0]
                + "年 " + birthday[1] + "月 " + birthday[2] + "日 \n简介: " + resume);
    }

    public static void save(Info info) {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\workspaceFolder\\CODE_JAVA\\InfoSystem\\Info.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos); // 连接
            oos.writeObject(info);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Info read(ObjectInputStream ois) {
        Info ret;
        try {
            ret = (Info) ois.readObject();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return new Info();
        }

    }
}
