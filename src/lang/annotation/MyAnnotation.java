package lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// * public @interface MyAnnotation {}

// * javac d:\workspaceFolder\CODE_JAVA\lang\annotation\MyAnnotation.java

// * javap d:\workspaceFolder\CODE_JAVA\lang\annotation\MyAnnotation.class
// * Compiled from "MyAnnotation.java" public interface
// * lang.annotation.MyAnnotation extends java.lang.annotation.Annotation { }

// * 注解定义

// * 属性: 接口中的抽象方法
// * --1. 返回值
// * ----基本数据类型
// * ----String
// * ----枚举
// * ----注解
// * ----以上类型的数组
// * --2. 属性赋值
// * ----使用default初始化
// * ----如果只有value这一个属性需要赋值,则value=可省略
// * ----数组赋值用{},如果只有一个元素,则{}可以省略

// * 元注解:用于描述注解的注解
// * --@Target: 注解作用位置
// * --@Retention: 注解保留阶段(一般RUNTIME)
// * --@Documented: 注解是否被抽取到javadoc中
// * --@Inhearited: 注解是否被继承

// * 解析注解:获取属性值

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
    int value() default 12;

    String name() default "quanwei";

    Report report()default @Report ;
}
