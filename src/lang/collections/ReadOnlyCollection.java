package lang.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReadOnlyCollection {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("tang");
        arrayList.add("tang1");
        arrayList.add("tang2");
        arrayList.add("tang3");
        arrayList.add("quanwei");
        Collection<String> unmodify = Collections.unmodifiableCollection(arrayList);
        System.out.println(arrayList);
        System.out.println(unmodify);
        unmodify.add("sda");// java.lang.UnsupportedOperationException
        System.out.println(unmodify);
    }
}
