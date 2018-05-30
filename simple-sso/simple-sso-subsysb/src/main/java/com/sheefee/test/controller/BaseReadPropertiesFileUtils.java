package com.sheefee.test.controller;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * Created by ThinkPad on 2017/11/12
 * @author ThinkPad
 */
public class BaseReadPropertiesFileUtils {

    protected static PropertiesConfiguration configuration = null;

    public static void init(String fileName) {
        try {
            configuration = new PropertiesConfiguration(fileName);
            FileChangedReloadingStrategy changedReloadingStrategy = new FileChangedReloadingStrategy();
            changedReloadingStrategy.setRefreshDelay(1000 * 60 * 1);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
