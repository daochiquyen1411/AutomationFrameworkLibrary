package quyendc.helper.files;

import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class YmlTest {
    private String path = System.getProperty("user.dir");

    @Test
    public void ymlTest() throws FileNotFoundException {
        HashMap <? ,?> locators = YmlHelper.read(path + "/src/test/resources/files/YmlSample.yml");
        System.out.println(path);
        System.out.println(locators);
    }
}
