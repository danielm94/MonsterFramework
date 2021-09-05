package ui.utility.driver.driver_builder;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.FrameworkPropertyFile;
import ui.utility.driver.BuilderCatalog;

import java.net.URL;

public final class RemoteDriverBuilder {
    private RemoteDriverBuilder() {
    }

    public static WebDriver createDriverInstance(URL gridURL, BuilderCatalog type) {
        Capabilities capabilities = type.getDriverCapabilities()
                                        .getOptions();
        String operatingSystemString = PropertyReader.getProperty(FrameworkPropertyFile.APPLICATION_PROPERTIES, "platform");
        OperatingSystem operatingSystem = OperatingSystem.valueOf(operatingSystemString);
        WebDriverManager.seleniumServerStandalone()
                        .operatingSystem(operatingSystem)
                        .setup();
        return new RemoteWebDriver(gridURL, capabilities);
    }
}
