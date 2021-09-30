package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public final class ClearInput {
    private ClearInput() {
    }

    public static void usingLocator(By locator) {
        WebElement element = FindElement.usingLocator(locator);
        element.clear();
    }

    public static void usingElement(WebElement element) {
        Sync.waitUntilVisible(element);
        element.clear();
    }

    public static void byValueUsingLocator(By locator) {
        WebElement element = FindElement.usingLocator(locator);
        while (element.getAttribute("value")
                      .length() > 0) {
            SendKeys.usingElement(element, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    public static void byValueUsingElement(WebElement element) {
        while (element.getAttribute("value")
                      .length() > 0) {
            SendKeys.usingElement(element, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    public static void byVisibleTextUsingLocator(By locator) {
        WebElement element = FindElement.usingLocator(locator);
        while (element.getText()
                      .length() > 0) {
            SendKeys.usingElement(element, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    public static void byVisibleTextUsingElement(WebElement element) {
        while (element.getText()
                      .length() > 0) {
            SendKeys.usingElement(element, Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }
}
