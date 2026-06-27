package lk.kns.school.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogConfig {

    public static void setup() {
        Logger rootLogger = Logger.getLogger("");

        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);

            rootLogger.setLevel(Level.INFO);

            System.out.println("Logging initialized. Writing to app.log");
        } catch (IOException e) {
            System.err.println("Could not setup logger: " + e.getMessage());
        }
    }
}
