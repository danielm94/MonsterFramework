package ui.utility.driver;

import org.openqa.selenium.InvalidArgumentException;
import ui.utility.driver.browser_options.*;
import ui.utility.driver.driver_builder.*;
/*
Author: Daniel Martins
Email: daniel.d.martins@outlook.com
*/

/**
 * Enum
 */
public enum BuilderCatalog {
    CHROME(new ChromeDriverBuilder(), new ChromeCapabilities()),
    FIREFOX(new FirefoxDriverBuilder(), new FirefoxCapabilities()),
    OPERA(new OperaDriverBuilder(), new OperaCapabilities()),
    EDGE(new EdgeDriverBuilder(), new EdgeCapabilities()),
    IEXPLORER(new IEDriverBuilder(), new IECapabilities());

    private final DriverBuilder driverBuilder;
    private final DriverCapabilities driverCapabilities;


    BuilderCatalog(DriverBuilder builder, DriverCapabilities driverCapabilities) {
        this.driverBuilder = builder;
        this.driverCapabilities = driverCapabilities;
    }

    public DriverBuilder getDriverBuilder() {
        return driverBuilder;
    }

    public DriverCapabilities getDriverCapabilities() {
        return driverCapabilities;
    }

    public static BuilderCatalog parseString(String browser) {
        browser = browser.toLowerCase();
        if (browser.contains("firefox")) {
            return BuilderCatalog.FIREFOX;
        } else if (browser.contains("chrome")) {
            return BuilderCatalog.CHROME;
        } else if (browser.contains("edge")) {
            return BuilderCatalog.EDGE;
        } else if (browser.contains("explorer")) {
            return BuilderCatalog.IEXPLORER;
        } else if (browser.contains("opera")) {
            return BuilderCatalog.OPERA;
        } else {
            throw new InvalidArgumentException("\"" + browser + "\" is not a supported browser.");
        }
    }
}
