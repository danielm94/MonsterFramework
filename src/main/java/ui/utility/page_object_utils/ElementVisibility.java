package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public final class ElementVisibility {
    private ElementVisibility() {
    }

    public static boolean usingLocator(By locator) {
        try {
            Sync.waitUntilVisible(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean usingElement(WebElement element) {
        try {
            Sync.waitUntilVisible(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean usingLocator(By locator, Duration duration) {
        try {
            Sync.waitUntilVisible(locator, duration);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean usingElement(WebElement element, Duration duration) {
        try {
            Sync.waitUntilVisible(element, duration);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
