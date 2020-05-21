package com.itcorey.pojo;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @Classname user
 * @Description TODO
 * @Date 2020/5/21 11:43
 * @Created by corey
 */
@Data
public class User {

    private String openId;

    private String daysId;

    private String title;

    private int itemNumber;

    private String date;

}
