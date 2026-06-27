package lk.kns.school.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigLoader {

    private static final Logger LOGGER = Logger.getLogger(ConfigLoader.class.getName());
    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            LOGGER.info("Config loaded successfully.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error: Could not find or load config.properties file!", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

}
