package quyendc.keywords.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface TimeoutContext {

    WebElement waitUntilElementIsClickable(By locator);

    WebElement waitUntilElementIsVisible(By locator);

    WebElement waitUntilElementIsPresent(By locator);
}
