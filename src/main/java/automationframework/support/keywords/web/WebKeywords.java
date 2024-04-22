package automationframework.support.keywords.web;

import automationframework.support.keywords.core.BaseKeywords;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.Require;

public class WebKeywords extends BaseKeywords implements IWebKeywords {

    public WebKeywords(WebDriver driver){
        super(driver);
    }

    /**
     * Opens the specified URL in the web browser.
     * @param url the URL to be opened
     * @throws Exception if the URL format is invalid or if any other error occurs during navigation
     */
    @Override
    public void openUrl(String url) throws Exception {
        Require.nonNull("Url ", url);
        if (!(url.startsWith("http://") || url.startsWith("https://"))){
            throw new Exception("Invalid URL format!");
        }
        driver.get(url);
    }

    /**
     * Performs a click action on the specified web element.
     * @param element the web element to be clicked
     * @throws ElementClickInterceptedException if the element is not clicked
     */
    @Override
    public void click(WebElement element) {
        Require.nonNull("WebElement ", element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println(this.getClass().getName() + "click " + "Element not clickable" + element);
            throw e;
        }
    }

    /**
     * Clicks on the element identified by the specified locator.
     * @param locator the locator used to identify the element to click on
     * @throws NoSuchElementException         if the element identified by the locator is not found
     * @throws ElementClickInterceptedException if the element is found but cannot be clicked
     */
    @Override
    public void click(By locator) {
        Require.nonNull("By locator ", locator);
        try {
            element = driver.findElement(locator);
            element.click();
        } catch (NoSuchElementException e){
            System.out.println(this.getClass().getName() + "click " + "Element not found" + locator);
            throw e;
        } catch (ElementClickInterceptedException e) {
            System.out.println(this.getClass().getName() + "click " + "Element not clickable" + locator);
            throw e;
        }
    }


}
