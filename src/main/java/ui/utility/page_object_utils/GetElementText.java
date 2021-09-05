package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

public final class GetElementText {
    private GetElementText() {
    }

    public static String usingLocator(By locator) {
        return Sync.waitUntilVisible(locator)
                   .getText();
    }

    public static String usingElement(WebElement element) {
        return Sync.waitUntilVisible(element)
                   .getText();
    }

    public static String usingLocator(By locator, Duration duration) {
        return Sync.waitUntilVisible(locator, duration)
                   .getText();
    }

    public static String usingElement(WebElement element, Duration duration) {
        return Sync.waitUntilVisible(element, duration)
                   .getText();
    }

    public static String usingBooleanCondition(By locator, ExpectedCondition<Boolean> condition) {
        Sync.waitUntilBooleanCondition(condition);
        return FindElement.usingLocator(locator)
                          .getText();
    }

    public static String usingBooleanCondition(WebElement element, ExpectedCondition<Boolean> condition) {
        Sync.waitUntilBooleanCondition(condition);
        return element.getText();
    }

    public static String usingBooleanCondition(By locator, ExpectedCondition<Boolean> condition, Duration duration) {
        Sync.waitUntilBooleanCondition(condition, duration);
        return FindElement.usingLocator(locator)
                          .getText();
    }

    public static String usingBooleanCondition(WebElement element, ExpectedCondition<Boolean> condition, Duration duration) {
        Sync.waitUntilBooleanCondition(condition, duration);
        return element.getText();
    }

    public static String usingElementCondition(ExpectedCondition<WebElement> condition) {
        return Sync.waitUntilWebElementCondition(condition)
                   .getText();
    }

    public static String usingElementCondition(ExpectedCondition<WebElement> condition, Duration duration) {
        return Sync.waitUntilWebElementCondition(condition, duration)
                   .getText();
    }
}
