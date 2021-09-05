package ui.utility.driver.browser_options;

import org.openqa.selenium.chrome.ChromeOptions;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.BrowserPropertyFile;

public final class ChromeCapabilities implements DriverCapabilities {
    @Override
    public ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(PropertyReader
                .getFileAsList(BrowserPropertyFile.CHROME_PROPERTIES));
        return options;
    }
}
