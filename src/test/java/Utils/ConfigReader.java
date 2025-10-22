package Utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Нет конфига");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки конфига", e);
        }
    }

    public static String getEmail(){
        return properties.getProperty("test.user.email");
    }

    public static String getPassword(){
        return properties.getProperty("test.user.password");
    }

    public static String getBaseUrl(){
        return properties.getProperty("base.url");
    }
}
