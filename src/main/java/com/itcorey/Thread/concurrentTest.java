package com.itcorey.Thread;

import java.io.Serializable;

/**
 * @Classname concurrentTest
 * @Description 多线程一定快吗?
 * @Date 2020/5/21 18:32
 * @Created by corey
 */
public class concurrentTest {

    private static final long count = 100000000;

    public static void main(String[] args) throws Exception {
        //并发
        concurrentcy();
        //串行
        Serial();
    }

    private static void concurrentcy() throws Exception {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        ;
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrentcy==并发"+time+"ms,b="+b);
    }

    private static void Serial() {
        long start = System.currentTimeMillis();
        int a  = 0;
        for (long i = 0;i< count;i++){
            a+=5;
        }
        int b = 0;
        for (long i = 0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Serial==串行:"+time+"ms,b"+b+",a="+a);
    }


}
