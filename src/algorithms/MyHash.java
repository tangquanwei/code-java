package algorithms;


/**
 * @Description: D-J-B-hash, E-L-F-hash A-P-Hash, J-S-Hash
 * @ClassName: MyHash
 * @Author: QUANWEI
 * @Date: 2021/12/12 21:06
 * @Version: 1.0
 */
public class MyHash {

    public static long djbHash(String str){ //times 33
        byte[] bytes = str.getBytes();
        long hash=5301;
        int c=0;
        while(c<bytes.length){
            hash=((hash<<5)+hash)+bytes[c];
            c++;
        }
        return hash;
    }

    public static void main(String[] args) {

        System.out.println(djbHash("tang"));
    }
}
