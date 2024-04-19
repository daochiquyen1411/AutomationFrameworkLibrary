package quyendc.keywords.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quyendc.keywords.core.IKeywords;

public interface IMobileKeywords extends IKeywords {

    void tap(WebElement element);

    void tap(By locator);

    void tap (double xPosition, double yPosition);
}
