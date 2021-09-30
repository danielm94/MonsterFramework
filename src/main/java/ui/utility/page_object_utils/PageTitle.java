package ui.utility.page_object_utils;

import ui.utility.driver.Driver;

import java.time.Duration;

public final class PageTitle {
    private PageTitle() {
    }

    public static boolean contains(String title) {
        return Sync.waitUntilTitleContains(title);
    }

    public static boolean contains(String title, Duration duration) {
        return Sync.waitUntilTitleContains(title, duration);
    }

    public static boolean matchesExactly(String exactTitle) {
        return Sync.waitUntilTitleMatchesExactly(exactTitle);
    }

    public static boolean matchesExactly(String exactTitle, Duration duration) {
        return Sync.waitUntilTitleMatchesExactly(exactTitle, duration);
    }

    public static String getTitle() {
        return Driver.getInstance()
                     .getDriver()
                     .getTitle();
    }
}
