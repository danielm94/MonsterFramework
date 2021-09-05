package ui.page_objects.home_page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import shared_utilities.report_utility.Log;
import ui.utility.driver.Driver;
import ui.utility.page_object_utils.Click;
import ui.utility.page_object_utils.PageObject;
import ui.utility.page_object_utils.PageTitle;
import ui.utility.page_object_utils.PageURL;

public final class HomePage implements PageObject {
    public static final String EXPECTED_HOME_PAGE_URL = "https://www.monster.ca/";
    @FindBy(css = "a[title='Profile']")
    WebElement profileButton;

    public HomePage() {
        Driver.getInstance()
              .getDriver()
              .manage()
              .window()
              .maximize();
        PageFactory.initElements(Driver.getInstance()
                                       .getDriver(), this);
    }

    @Override
    public boolean isPageLoaded() {
        Log.log(Status.INFO, "Checking if home page has loaded...");
        try {
            PageURL.contains(EXPECTED_HOME_PAGE_URL);
            Log.log(Status.INFO, "Home page is loaded.");
            return true;
        } catch (TimeoutException e) {
            Log.log(Status.WARNING, "The page URL did not contain the expected URL for the home page. Home page did not load correctly.");
            return false;
        }
    }

    @Override
    public void navigateToPage() {
        Driver.getInstance()
              .getDriver()
              .get(EXPECTED_HOME_PAGE_URL);
    }

    @Override
    public boolean isPageTitleValid(String title) {
        Log.log(Status.INFO, "Checking if the home page title is valid...");
        try {
            PageTitle.matchesExactly(title);
            Log.log(Status.INFO, "Title was displayed correctly.");
            return true;
        } catch (TimeoutException e) {
            Log.log(Status.WARNING, "Home page did not load the correct title! Expected: " + title + " | Found: " + Driver.getInstance()
                                                                                                                          .getDriver()
                                                                                                                          .getTitle());
            return false;
        }
    }

    public void clickProfileButton() {
        Click.usingElement(profileButton);
    }
}
