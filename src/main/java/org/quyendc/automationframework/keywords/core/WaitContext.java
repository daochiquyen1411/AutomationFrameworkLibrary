package org.quyendc.automationframework.keywords.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface WaitContext {

    WebElement waitUntilElementIsClickable(By locator);

    WebElement waitUntilElementIsVisible(By locator);

    WebElement waitUntilElementIsPresent(By locator);
}
