package automationframework.support.helper.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesHelper {

    public static Map<? , ?> read(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            Properties prop = new Properties();
            prop.load(input);
            return new HashMap<>(prop);
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file: " + filePath + " " + e);
        }
    }
}
