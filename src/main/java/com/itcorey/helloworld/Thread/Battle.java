package com.itcorey.helloworld.Thread;

import com.itcorey.helloworld.vo.Hero;

/**
 * Created by ：Corey
 * 21:02 2018/12/17
 * 战斗类
 */
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
