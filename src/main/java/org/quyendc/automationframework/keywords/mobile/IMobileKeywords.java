package org.quyendc.automationframework.keywords.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IMobileKeywords {

    void tap(WebElement element);

    void tap(By locator);

    void tap (double xPosition, double yPosition);
}
