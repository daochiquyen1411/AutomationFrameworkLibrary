package quyendc.helper.files;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class YmlHelper extends BaseFiles {

    public static <T> T read(String filePath) throws FileNotFoundException {
        try {
            Yaml yaml = new Yaml();
            T yamlData = yaml.load(new FileInputStream(filePath));
            return yamlData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
