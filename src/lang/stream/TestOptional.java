package lang.stream;

import java.util.Optional;

/**
 * Optional<T>解决空指针异常
 */
public class TestOptional {
    public static void main(String[] args) {
        // 创建空的
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());
        // of 不能为空
        Optional<String> of = Optional.of("dasda");
        String string = of.get();
        System.out.println(string);

        // ofNullable
        Optional<Object> ofNullable = Optional.ofNullable(null);
        Object object = ofNullable.orElse("是空的");
        System.out.println(object);

    }
}
