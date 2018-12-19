package com.itcorey.helloworld.Thread;

import com.itcorey.helloworld.vo.Hero;

/**
 * Created by ：Corey
 * 20:24 2018/12/17
 * 线程类
 */
public class TestThread {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        System.out.println("-------------");
        /**************************继承Thread类*********************************************************/
        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();

        System.out.println("======>1");
        /*****************************实现Runnable接口********************************************************************/
        Battle battle1 = new Battle(gareen,teemo);
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();

        System.out.println("========>2");
        /*****************************匿名内部类********************************************************************/
        Thread t1 = new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();



    /*******join方法加入到时间*****************************主线程概念--加入到线程*************************************************************/















    }

}
