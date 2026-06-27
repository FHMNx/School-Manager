package lk.kns.school.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            System.out.println("Config loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error: Could not find or load config.properties file!");
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

}
