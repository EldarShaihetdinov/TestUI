package ru.dexsys;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties = new Properties();

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public void loadProperties() {

        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
