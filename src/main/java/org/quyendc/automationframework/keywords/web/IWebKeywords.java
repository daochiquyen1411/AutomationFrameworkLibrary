package org.quyendc.automationframework.keywords.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IWebKeywords {

    void openUrl (String url) throws Exception;

    void click(WebElement element);

    void click(By locator);
}
