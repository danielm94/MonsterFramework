package ui.page_objects.profile_page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import shared_utilities.report_utility.Log;
import ui.utility.driver.Driver;
import ui.utility.page_object_utils.*;

public final class WorkExperiencePage implements PageObject {
    @FindBy(css = "input[data-testid=\"experience-company-name-input\"]")
    WebElement companyNameInput;

    @FindBy(css = "button[data-testid=\"dialog-control-profile-experience-edit-form-control-submit-button\"]")
    WebElement saveChangesButton;

    public WorkExperiencePage() {
        PageFactory.initElements(Driver.getInstance()
                                       .getDriver(), this);
    }

    @Override
    public boolean isPageTitleValid(String title) {
        return false;
    }

    public String getCompanyName() {
        return GetAttribute.usingElement(companyNameInput, "value");
    }

    public void enterCompanyName(String companyName) {
        ClearInput.byValueUsingElement(companyNameInput);
        SendKeys.usingElement(companyNameInput, companyName);
        Log.log(Status.INFO, "Entered " + companyName + " into the company name input.");
    }

    public void clickSaveChangesButton() {
        ScrollIntoView.usingElement(saveChangesButton);
        Click.usingElement(saveChangesButton);
        Log.log(Status.INFO, "Clicked on the save changes button.");
    }
}
