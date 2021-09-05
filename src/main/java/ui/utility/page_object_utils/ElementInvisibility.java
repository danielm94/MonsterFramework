package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public final class ElementInvisibility {
    private ElementInvisibility() {
    }

    public static boolean usingLocator(By locator) {
        return Sync.waitUntilInvisible(locator);
    }

    public static boolean usingElement(WebElement element) {
        return Sync.waitUntilInvisible(element);
    }

    public static boolean usingLocator(By locator, Duration duration) {
        return Sync.waitUntilInvisible(locator, duration);
    }

    public static boolean usingElement(WebElement element, Duration duration) {
        return Sync.waitUntilInvisible(element, duration);
    }
}
