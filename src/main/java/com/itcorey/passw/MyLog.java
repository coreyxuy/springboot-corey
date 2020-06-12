package com.itcorey.passw;

import java.lang.annotation.*;

/**
 * @Classname MyLog
 * @Description 日志处理
 * @Date 2020/6/12 14:44
 * @Created by corey
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface  MyLog {

    String value() default "";
}
