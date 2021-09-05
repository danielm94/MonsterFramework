package ui.utility.driver.browser_options;

import org.openqa.selenium.edge.EdgeOptions;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.BrowserPropertyFile;

public final class EdgeCapabilities implements DriverCapabilities {
    @Override
    public EdgeOptions getOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments(PropertyReader
                .getFileAsList(BrowserPropertyFile.EDGE_PROPERTIES));
        return options;
    }
}
