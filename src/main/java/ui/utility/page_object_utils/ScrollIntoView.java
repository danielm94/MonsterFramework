package ui.utility.page_object_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class ScrollIntoView {

    private ScrollIntoView() {
    }

    public static void usingLocator(By locator) {
        WebElement element = FindElement.usingLocator(locator);
        JsExecutor.executeScriptWithArguments("arguments[0].scrollIntoView(true);", element);
    }

    public static void usingElement(WebElement element) {
        JsExecutor.executeScriptWithArguments("arguments[0].scrollIntoView(true);", element);
    }
}
