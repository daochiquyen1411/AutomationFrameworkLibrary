package quyendc.automationframework.helpers.files;

import org.quyendc.automationframework.helper.files.PropertiesHelper;

import java.util.HashMap;

public class PropertiesTest {
    public static void main(String[] args) {
        HashMap<? , ?> locators = (HashMap<?, ?>) PropertiesHelper.read("/Users/anass/OneDrive/Documents/Automation/AutomationFrameworkLibrary/src/test/resources/files/PropertiesSample.properties");
        System.out.println(locators);
    }
}
