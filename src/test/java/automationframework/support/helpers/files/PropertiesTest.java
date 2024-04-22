package automationframework.support.helpers.files;

import automationframework.support.helper.files.PropertiesHelper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PropertiesTest {

    @Test
    public void propertiesTest() {
        HashMap<? , ?> locators = (HashMap<?, ?>) PropertiesHelper.read("/Users/anass/OneDrive/Documents/Automation/AutomationFrameworkLibrary/src/test/resources/files/PropertiesSample.properties");
        System.out.println(locators);
    }
}
