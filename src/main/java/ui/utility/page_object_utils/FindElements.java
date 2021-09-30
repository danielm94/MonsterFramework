package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.utility.driver.Driver;

import java.time.Duration;
import java.util.List;

public final class FindElements {
    private FindElements() {
    }

    public static List<WebElement> usingLocator(By locator) {
        Sync.waitUntilAllVisible(locator);
        return Driver.getInstance()
                     .getDriver()
                     .findElements(locator);
    }

    public static List<WebElement> usingLocator(By locator, Duration duration) {
        Sync.waitUntilAllVisible(locator);
        return Driver.getInstance()
                     .getDriver()
                     .findElements(locator);
    }
}
