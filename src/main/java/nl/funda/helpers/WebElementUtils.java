package nl.funda.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static nl.funda.helpers.Driver.getDriver;

public class WebElementUtils {

    private static final int WAIT_DURATION_IN_SECONDS = 10;
    private static WebDriverWait wait;

    static {
        WebDriver driver = Driver.getDriver();
        if (driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION_IN_SECONDS));
        }
    }

    public static void click(WebElement element) {
        verifyClickable(element);
        element.click();
    }

    public static void click(List<WebElement> elements, final int index) {
        verifyVisible((elements));
        elements.get(index).click();
    }

    public static void forceClick(WebElement element) {
        verifyClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static String getText(WebElement element) {
        verifyVisible(element);
        return element.getText();
    }

    public static String getText(List<WebElement> elements, final int index) {
        verifyVisible(elements);
        return elements.get(index).getText();
    }

    public static String getAttributeValue(WebElement element, final String attributeName) {
        verifyVisible(element);
        return element.getAttribute(attributeName);
    }

    public static int getSize(List<WebElement> elements) {
        verifyVisible(elements);
        return elements.size();
    }

    public static void selectByValue(WebElement element, final String value) {
        verifyClickable(element);
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void fillText(WebElement element, final String text) {
        verifyClickable(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void verifyClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void verifyVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void verifyVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void verifyTextToBePresent(WebElement element, final String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void verifyAttributeToBe(WebElement element, final String attributeName, final String attributeValue) {
        wait.until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }
}
