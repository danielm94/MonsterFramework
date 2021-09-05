package ui.utility.driver.browser_options;

import org.openqa.selenium.opera.OperaOptions;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.BrowserPropertyFile;

public final class OperaCapabilities implements DriverCapabilities {
    @Override
    public OperaOptions getOptions() {
        OperaOptions options = new OperaOptions();
        options.addArguments(PropertyReader
                .getFileAsList(BrowserPropertyFile.OPERA_PROPERTIES));
        return options;
    }
}
