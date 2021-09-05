package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

public final class FindElement {
    private FindElement() {
    }

    /**
     * Finds an element by using a locator.
     *
     * @param locator Locator to find element (E.g., "By.Id")
     * @return WebElement
     */
    public static WebElement usingLocator(By locator) {
        return Sync.waitUntilVisible(locator);
    }

    public static WebElement usingLocator(By locator, Duration duration) {
        return Sync.waitUntilVisible(locator, duration);
    }

    public static WebElement usingExpectedCondition(ExpectedCondition<WebElement> condition) {
        return Sync.waitUntilWebElementCondition(condition);
    }

    public static WebElement usingExpectedCondition(ExpectedCondition<WebElement> condition, Duration duration) {
        return Sync.waitUntilWebElementCondition(condition, duration);
    }
}
