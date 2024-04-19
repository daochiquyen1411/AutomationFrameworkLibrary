package quyendc.keywords.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quyendc.keywords.core.IKeywords;

public interface IWebKeywords extends IKeywords {

    void openUrl (String url) throws Exception;

    void click(WebElement element);

    void click(By locator);
}
