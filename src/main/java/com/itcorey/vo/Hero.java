package com.itcorey.vo;

/**
 * Created by ：Corey
 * 10:31 2018/12/17
 * 常用英雄实体类
 *
 */
public class Hero {

    public String name;

    public float hp;

    public int damage;

    public Hero(String name){
        this.name = name;
    }

    public Hero() {

    }

    public void attackHero(Hero h){

        try {
            //攻击时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead()){
            System.out.println(h.name + "死了！");
        }
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }

    //攻击时间为3次
    int totalTime = 3;

    public void adugen() {
        while (true) {
            for (int i = 0; i < totalTime; i++) {
                System.out.printf("波动拳第%d发%n", i + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("开始为时5秒的充能");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "红仔";
        h.adugen();;

    }
}
