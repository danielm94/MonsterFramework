package ui.utility.driver.browser_options;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.BrowserPropertyFile;

public final class FirefoxCapabilities implements DriverCapabilities {
    @Override
    public FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        options.setHeadless(Boolean
                .parseBoolean(PropertyReader
                        .getProperty(BrowserPropertyFile.FIREFOX_PROPERTIES, "headless")));
        firefoxProfile.setAcceptUntrustedCertificates(Boolean
                .parseBoolean(PropertyReader
                        .getProperty(BrowserPropertyFile.FIREFOX_PROPERTIES, "AcceptUntrustedCertificates")));
        firefoxProfile.setAssumeUntrustedCertificateIssuer(Boolean
                .parseBoolean(PropertyReader
                        .getProperty(BrowserPropertyFile.FIREFOX_PROPERTIES, "AssumeUntrustedCertificateIssuer")));
        options.setProfile(firefoxProfile);
        return options;
    }
}
