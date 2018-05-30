package com.sheefee.test.controller;

/**
 * Created by ThinkPad on 2017/11/12
 * 读取 jdbc.properties
 */
public class JdbcReadPropertiesUtils extends BaseReadPropertiesFileUtils {

    static {
        init("jdbc.properties");
    }

    public static String getValueByKey(String keyStr) {
        return configuration.getString(keyStr);
    }

}
