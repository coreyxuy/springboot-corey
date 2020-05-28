package com.itcorey.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @Classname SpringBeanUtil
 * @Description TODO
 * @Date 2020/5/28 17:11
 * @Created by corey
 */
public class SpringBeanUtil {

    private static ApplicationContext applicationContext;
    static final private Object lock = new Object();

    /** * 设置上下文 * * @param applicationContext * @throws BeansException */
    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        synchronized (lock) {
            if (SpringBeanUtil.applicationContext == null) {
                SpringBeanUtil.applicationContext = applicationContext;
            }
        }
    }

    /** * 获取applicationContext * * @return */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /** * 通过name获取 Bean * * @param name * @return */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /** * 通过class获取Bean * * @param clazz * @return */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /** * 通过name,以及Clazz返回指定的Bean * * @param name * @param clazz * @return */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
