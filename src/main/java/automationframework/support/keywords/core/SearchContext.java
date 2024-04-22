package automationframework.support.keywords.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface SearchContext {

    List<WebElement> findElements(By locator);

    WebElement findElement(By locator);
}
