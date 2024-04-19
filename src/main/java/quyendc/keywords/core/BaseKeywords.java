package quyendc.keywords.core;

import org.openqa.selenium.*;
import org.openqa.selenium.internal.Require;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;

/**
Author: dao chi quyen
Support:
 org.seleniumhq.selenium ver 4.18.1
 io.appium ver 9.2.2
*/
public abstract class BaseKeywords implements IKeywords, SearchContext, TimeoutContext, IAlert {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement element;
    protected JavascriptExecutor jsExecutor;
    protected long ExplicitWaitTimeout = 30;
    protected long ImplicitWaitTimeout = 10;

    public BaseKeywords(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ImplicitWaitTimeout));
        wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWaitTimeout));
    }

    /**
     * Retrieves the WebDriver instance associated with this object.
     * @return the WebDriver instance
     */
    public WebDriver getDriver(){
        return this.driver;
    }

    /**
     * Finds the first web element using the given locator.
     * @param locator the locator strategy used to find the element
     * @return the first web element matching the given locator
     * @throws NoSuchElementException if no element matching the given locator is found
     */
    @Override
    public WebElement findElement(By locator) {
        Require.nonNull("Locator ", locator);
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.out.println(this.getClass().getName() + "findElement" + " Element not found" + locator);
            throw e;
        }
    }

    /**
     * Finds all web elements using the given locator.
     * @param locator the locator strategy used to find the elements
     * @return a list of web elements matching the given locator
     * @throws NoSuchElementException if no elements matching the given locator are found
     */
    @Override
    public List<WebElement> findElements(By locator){
        Require.nonNull("Locator ", locator);
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException e) {
            System.out.println(this.getClass().getName() + "findElements" + " Element not found" + locator);
            throw e;
        }
    }

    /**
     * Waits until the element located by the given locator is clickable.
     * @param locator the locator strategy used to find the element
     * @return the web element once it is clickable
     * @throws TimeoutException if the element is not clickable within the specified timeout period
     */
    @Override
    public WebElement waitUntilElementIsClickable(By locator) {
        Require.nonNull("Locator ", locator);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.out.println(this.getClass().getName() + "waitUntilElementIsClickable" + " Element not clickable" + locator);
            throw e;
        }
    }

    /**
     * Waits until the element located by the given locator is visible.
     * @param locator the locator strategy used to find the element
     * @return the web element once it is visible
     * @throws TimeoutException if the element is not visible within the specified timeout period
     */
    @Override
    public WebElement waitUntilElementIsVisible(By locator) {
        Require.nonNull("Locator ", locator);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println(this.getClass().getName() + "waitUntilElementIsVisible" + " Element not visible" + locator);
            throw e;
        }
    }

    /**
     * Waits until the element located by the given locator is present.
     * @param locator the locator strategy used to find the element
     * @return the web element once it is present
     * @throws TimeoutException if the element is not present within the specified timeout period
     */
    @Override
    public WebElement waitUntilElementIsPresent(By locator){
        Require.nonNull("Locator ", locator);
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println(this.getClass().getName() + "waitUntilElementIsVisible" + " Element not present" + locator);
            throw e;
        }
    }

    /**
     * Sets the implicit wait timeout duration.
     * @param timeout the timeout duration in seconds
     */
    public void setImplicitWaitTimeout(long timeout){
        Require.nonNull("Timeout ", timeout);
        this.ImplicitWaitTimeout = timeout;
    }

    /**
     * Sets the explicit wait timeout duration.
     * @param timeout the timeout duration in seconds
     */
    public void setExplicitWaitTimeout(long timeout){
        Require.nonNull("Timeout ", timeout);
        this.ExplicitWaitTimeout = timeout;
    }

    /**
     * Lấy văn bản từ cửa sổ cảnh báo.
     * @return Văn bản từ cửa sổ cảnh báo, nếu có.
     * @throws NoAlertPresentException Nếu không có cửa sổ cảnh báo nào xuất hiện.
     */
    @Override
    public String getAlertText() throws NoAlertPresentException {
        try {
            return driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            System.out.println(this.getClass().getName() + " waitUntilAlertPresent " + "No alert present! " + e);
            throw e;
        }
    }

    /**
     * Checks whether an alert is present.
     * @return True if an alert is present, false otherwise.
     * @throws NoAlertPresentException If no alert is present.
     */
    @Override
    public boolean isAlertPresent() throws NoAlertPresentException {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (NoAlertPresentException e) {
            System.out.println(this.getClass().getName() + " getAlertText " + "No alert present! ");
            return false;
        }
    }

    /**
     * Waits until an alert is present.
     *
     * @throws NoAlertPresentException If no alert is present.
     */
    public void waitUntilAlertPresent() throws NoAlertPresentException {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (NoAlertPresentException e) {
            System.out.println(this.getClass().getName() + " waitUntilAlertPresent " + "No alert present! " + e);
            throw e;
        }
    }

    /**
     * Accepts the alert present.
     * @throws NoAlertPresentException If no alert is present.
     */
    public void acceptAlert() throws NoAlertPresentException {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println(this.getClass().getName() + " waitUntilAlertPresent " + "No alert present! " + e);
            throw e;
        }
    }

    /**
     * Accepts the alert present.
     * @throws NoAlertPresentException If no alert is present.
     */
    public void dismissAlert() throws NoAlertPresentException {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println(this.getClass().getName() + " waitUntilAlertPresent " + "No alert present! " + e);
            throw e;
        }
    }
}
