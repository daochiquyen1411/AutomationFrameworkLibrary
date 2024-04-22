package automationframework.support.helpers.files;

import automationframework.support.helper.files.YmlHelper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class YmlTest {

    @Test
    public void ymlTest() {
        HashMap <? ,?> locators = YmlHelper.read("/Users/anass/OneDrive/Documents/Automation/AutomationFrameworkLibrary/src/test/resources/files/YmlSample.yml");
        System.out.println(locators);
    }
}
