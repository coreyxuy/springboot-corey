package com.itcorey.helloworld.Thread;

import com.itcorey.helloworld.vo.Hero;

/**
 * Created by ：Corey
 * 20:31 2018/12/17
 */
public class KillThread extends Thread{

    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}