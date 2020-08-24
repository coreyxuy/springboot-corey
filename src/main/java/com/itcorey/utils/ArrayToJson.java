package com.itcorey.utils;

import com.google.common.collect.HashBasedTable;

import java.util.Map;

/**
 * @Auther: corey
 * @Date: 2020/7/29 17:33
 * @Description: 集合转json
 */
public class ArrayToJson {

    public static void main(String[] args) {
        HashBasedTable<Integer, Integer, Integer> table = HashBasedTable.create();
        table.put(111,222,333);
        Map<Integer, Map<Integer, Integer>> rowMap = table.rowMap();
        System.out.println(rowMap);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("======");
            }
        }).start();


    }
}
