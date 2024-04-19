package quyendc.keywords.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.Require;
import quyendc.keywords.core.BaseKeywords;

import java.util.HashMap;

public class MobileKeywords extends BaseKeywords implements IMobileKeywords, IKeyboard {

    public MobileKeywords(WebDriver driver) {
        super(driver);
    }

    /**
     * Performs a tap action on the specified web element.
     * @param element the web element to be tapped
     * @throws ElementClickInterceptedException if the element is not clicked
     */
    @Override
    public void tap(WebElement element) {
        Require.nonNull("WebElement ", element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println(this.getClass().getName() + "tap" + "Element not clickable" + element);
            throw e;
        }
    }

    /**
     * Taps on the element identified by the specified locator.
     * @param locator the locator used to identify the element to tap on
     * @throws NoSuchElementException         if the element identified by the locator is not found
     * @throws ElementClickInterceptedException if the element is found but cannot be clicked
     */
    @Override
    public void tap(By locator) {
        Require.nonNull("By locator ", locator);
        try {
            element = driver.findElement(locator);
            element.click();
        } catch (NoSuchElementException | ElementClickInterceptedException e){
            System.out.println(this.getClass().getName() + "tap " + "Element not clickable" + locator);
            throw e;
        }
    }

    /**
     * Tap on an element at the specified coordinates.
     * @param xPosition  the X coordinate where the tap will occur
     * @param yPosition  the Y coordinate where the tap will occur
     */
    @Override
    public void tap(double xPosition, double yPosition) {
        Require.nonNull("X Position ", xPosition);
        Require.nonNull("Y Position ", yPosition);
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        jsExecutor.executeScript("mobile: tap", tapObject);
    }

    /**
     * Hides the keyboard based on the provided browser type.
     * @param browser the type of browser ("android" or "ios")
     * @throws IllegalArgumentException if the browser type is not supported
     * @throws WebDriverException      if an error occurs while hiding the keyboard
     */
    @Override
    public void hideKeyboard(String browser) {
        Require.nonNull("Browser ", browser);
        try {
            switch (browser.toLowerCase()) {
                case "android":
                    ((AndroidDriver) driver).hideKeyboard();
                    break;
                case "ios":
                    ((IOSDriver) driver).hideKeyboard();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } catch (WebDriverException e) {
            System.out.println(this.getClass().getName() + " hideKeyboard " + "Error hiding the keyboard: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Hides the keyboard if it is currently displayed on the screen.
     * @throws WebDriverException if an error occurs while hiding the keyboard
     */
    @Override
    public void hideKeyboard(){
        try {
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).hideKeyboard();
            } else if (driver instanceof IOSDriver) {
                ((IOSDriver) driver).hideKeyboard();
            } else {
                throw new IllegalArgumentException("Unsupported browser! ");
            }
        } catch (WebDriverException e) {
            System.out.println(this.getClass().getName() + " hideKeyboard " + "Error hiding the keyboard: " + e.getMessage());
            throw e;
        }
    }
}
