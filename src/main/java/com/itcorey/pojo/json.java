package com.itcorey.pojo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: corey
 * @Date: 2020/7/29 17:39
 * @Description:
 */
public class json {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
       // for (int i = 8; i < 10; i++) {
            RunnableThread thread = new RunnableThread();

            executorService.execute(thread);
       // }
        //关闭线程池
        executorService.shutdown();

    }

    static class RunnableThread implements Runnable {

        @Override
        public void run() {
            System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");
        }
    }

}
