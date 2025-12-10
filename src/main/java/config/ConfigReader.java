package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

public static void loadConfig() {
  prop = new Properties();
    try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
        prop.load(fis);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}

public static String get(String key) {
    if (prop==null) {
        loadConfig(); // load if not already loaded
    }
   return prop.getProperty(key);
}
}
