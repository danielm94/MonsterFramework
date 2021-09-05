package ui.utility.page_object_utils;

import java.time.Duration;

public final class PageURL {
    private PageURL() {
    }

    public static boolean contains(String URL) {
        return Sync.waitUntilURLContains(URL);
    }

    public static boolean contains(String URL, Duration duration) {
        return Sync.waitUntilURLContains(URL, duration);
    }

    public static boolean isExactMatch(String exactURL) {
        return Sync.waitUntilURLMatchesExactly(exactURL);
    }

    public static boolean isExactMatch(String exactURL, Duration duration) {
        return Sync.waitUntilURLMatchesExactly(exactURL, duration);
    }
}
