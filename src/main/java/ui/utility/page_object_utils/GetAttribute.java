package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class GetAttribute {
    private GetAttribute() {
    }

    public static String usingElement(WebElement element, String attribute) {
        Sync.waitUntilVisible(element);
        return element.getAttribute(attribute);
    }

    public static String usingLocator(By locator, String attribute) {
        WebElement element = FindElement.usingLocator(locator);
        return element.getAttribute(attribute);
    }
}
