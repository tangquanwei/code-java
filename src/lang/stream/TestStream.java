package lang.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 筛选,切片
 */
public class TestStream {

    @Test
    public void test1() {
            
    }

    @Test
    public void test2() {
        // 创建Stream一 通过数组
        var employees = Data.EMPLOYEES;
        Stream<String[]> stream = Arrays.stream(employees);

        var arrayList = new ArrayList<String[]>();
        for (String[] strings : employees) {
            arrayList.add(strings);
        }
        // 创建Stream二 通过集合
        // 返回顺序流
        Stream<String[]> stream2 = arrayList.stream();
        // System.out.println(stream2);
        // 返回并行流
        Stream<String[]> parallelStream = arrayList.parallelStream();

        // 创建Stream三 通过of
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6, 7);

    }

    @Test
    public void test3() {
        // 创建无限流
        Stream.iterate(0, T -> T + 2).limit(14).forEach(System.out::println);
        Stream.generate(Math::random).limit(14).forEach(System.out::println);

    }
}
