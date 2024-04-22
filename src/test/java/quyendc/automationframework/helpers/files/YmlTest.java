package quyendc.automationframework.helpers.files;

import org.quyendc.automationframework.helper.files.YmlHelper;
import java.util.HashMap;

public class YmlTest {
    public static void main(String[] args) {
        HashMap <? ,?> locators = YmlHelper.read("/Users/anass/OneDrive/Documents/Automation/AutomationFrameworkLibrary/src/test/resources/files/YmlSample.yml");
        System.out.println(locators);
    }
}
