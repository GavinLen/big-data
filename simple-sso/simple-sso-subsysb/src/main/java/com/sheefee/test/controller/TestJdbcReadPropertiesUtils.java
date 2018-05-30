package com.sheefee.test.controller;

/**
 * Created by ThinkPad on 2017/11/12
 */
public class TestJdbcReadPropertiesUtils {

    public static void main(String[] args) {
        System.out.println(JdbcReadPropertiesUtils.getValueByKey("jdbc.driver"));
        System.out.println(JdbcReadPropertiesUtils.getValueByKey("jdbc.url"));
    }
}
