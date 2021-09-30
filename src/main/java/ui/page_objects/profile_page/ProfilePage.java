package ui.page_objects.profile_page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import shared_utilities.report_utility.Log;
import ui.utility.driver.Driver;
import ui.utility.page_object_utils.*;

import java.time.Duration;

public final class ProfilePage implements PageObject {
    @FindBy(css = "div[data-testid='profile-loader']")
    WebElement profileLoader;
    private final By COMPANY_TITLE_LOCATOR = By.cssSelector("div[data-testid=\"profile-experience-detail-name\"]");

    public ProfilePage() {
        PageFactory.initElements(Driver.getInstance()
                                       .getDriver(), this);
    }

    @Override
    public boolean isPageTitleValid(String title) {
        return false;
    }

    public boolean isPageLoaded() {
        try {
            Sync.waitUntilInvisible(profileLoader);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private WebElement getEditWorkExperienceButton(int entry) {
        By locator = By.id("profile-experience-" + (entry - 1) + "-edit");
        Sync.waitUntilClickable(locator);
        return FindElement.usingLocator(locator);
    }

    public void clickEditWorkExperienceButton(int workExperienceEntry) {
        WebElement editWorkExperienceButton = getEditWorkExperienceButton(workExperienceEntry);
        Click.usingElement(editWorkExperienceButton, Duration.ofSeconds(30));
        Log.log(Status.INFO, "Clicked on edit work experience button for work experience entry " + workExperienceEntry);
    }
}
