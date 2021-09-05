package ui.utility.driver.driver_builder;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.FrameworkPropertyFile;
import ui.utility.driver.browser_options.EdgeCapabilities;

public final class EdgeDriverBuilder implements DriverBuilder {
    @Override
    public WebDriver createDriverInstance() {
        EdgeCapabilities capabilities = new EdgeCapabilities();
        EdgeOptions options = capabilities.getOptions();
        String operatingSystemString = PropertyReader.getProperty(FrameworkPropertyFile.APPLICATION_PROPERTIES, "platform");
        OperatingSystem operatingSystem = OperatingSystem.valueOf(operatingSystemString);
        WebDriverManager.edgedriver()
                        .operatingSystem(operatingSystem)
                        .setup();
        return new EdgeDriver(options);
    }
}
