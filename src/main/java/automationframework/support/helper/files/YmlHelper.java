package automationframework.support.helper.files;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class YmlHelper extends BaseFiles {

    public static <T> T read(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            Yaml yaml = new Yaml();
            return yaml.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
