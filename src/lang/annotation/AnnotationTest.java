package lang.annotation;

import java.lang.reflect.Method;

//import org.junit.Test;

import org.junit.jupiter.api.Test;

/**
 * 注解（Annotation）是Java语言用于工具处理的标注 注解可以配置参数，没有指定配置的参数使用默认值
 * 
 * 可以在编译，类加载，运行时被读取，并执行相应的处理
 * 
 * 框架 = 注解 + 反射 + 设计模式
 * 
 * 给谁用? 1.编译器 2.解析程序
 */

@GetClass(className = "Bean1", methodName = "show1")
public class AnnotationTest {
    @Test
    public void testAnnotation() {
        // 解析注解
        // GetClass an = new AnnotationTest().getClass().getAnnotation(GetClass.class);
        // 注解实现类的匿名子类
        GetClass an = AnnotationTest.class.getAnnotation(GetClass.class);
        System.out.println(an.className() + "\n" + an.methodName());
    }

}
