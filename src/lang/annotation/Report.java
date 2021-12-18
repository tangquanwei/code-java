// 元注解 有一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）

// 最常用的元注解是@Target。
// 使用@Target可以定义Annotation能够被应用于源码的哪些位置：
// 类或接口：ElementType.TYPE；
// 字段：ElementType.FIELD；
// 方法：ElementType.METHOD；
// 构造方法：ElementType.CONSTRUCTOR；
// 方法参数：ElementType.PARAMETER

// 另一个重要的元注解@Retention定义了Annotation的生命周期：
// 仅编译期：RetentionPolicy.SOURCE；
// 仅class文件：RetentionPolicy.CLASS； (默认)
// 运行期：RetentionPolicy.RUNTIME
package lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 3.用元注解配置注解 
// 必须设置@Target和@Retention，@Retention一般设置为RUNTIME，因为我们自定义的注解通常要求在运行期读取
@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {// 1.用@interface定义注解
    // 2.添加默认参数
    int type() default 0;

    String level() default "info";

    String value() default "";
    // 把最常用的参数定义为value()，推荐所有参数都尽量设置默认值
}
// 注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation，因此，读取注解，需要使用反射API
