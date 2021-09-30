package ui.utility.page_object_utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ui.utility.driver.Driver;

public final class JsExecutor {
    private JsExecutor() {
    }

    public static Object executeScript(String script) {
        WebDriver driver = Driver.getInstance()
                                 .getDriver();
        return ((JavascriptExecutor) driver).executeScript(script);
    }

    public static Object executeScriptWithArguments(String script, Object... args) {
        WebDriver driver = Driver.getInstance()
                                 .getDriver();
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }
}
