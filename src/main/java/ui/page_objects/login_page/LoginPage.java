package ui.page_objects.login_page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import shared_utilities.report_utility.Log;
import ui.utility.driver.Driver;
import ui.utility.page_object_utils.*;

public final class LoginPage implements PageObject {
    private static final String LOGIN_PAGE_URL = "https://www.monster.ca/profile/detail";
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "email-button")
    WebElement emailLoginButton;


    public LoginPage() {
        PageFactory.initElements(Driver.getInstance()
                                       .getDriver(), this);
    }

    public boolean isPageLoaded() {
        boolean emailFieldVisible = ElementVisibility.usingElement(emailField);
        boolean passwordFieldVisible = ElementVisibility.usingElement(passwordField);
        if (emailFieldVisible && passwordFieldVisible)
            Log.log(Status.INFO, "Email field and password field are visible. Login page is loaded.");
        else
            Log.log(Status.WARNING, "Email field and password field are not visible. Login page failed to load correctly.");
        return emailFieldVisible && passwordFieldVisible;
    }

    @Override
    public boolean isPageTitleValid(String title) {
        Log.log(Status.INFO, "Checking if the login page title is valid...");
        try {
            PageTitle.matchesExactly(title);
            Log.log(Status.INFO, "Title was displayed correctly.");
            return true;
        } catch (TimeoutException e) {
            Log.log(Status.WARNING, "Login page did not load the correct title! Expected: " + title + " | Found: " + PageTitle.getTitle());
            return false;
        }
    }

    public void enterEmail(String email) {
        ClearInput.usingElement(emailField);
        SendKeys.usingElement(emailField, email);
        Log.log(Status.INFO, "Entered email into the email field.");
    }

    public void enterPassword(String password) {
        ClearInput.usingElement(passwordField);
        SendKeys.usingElement(passwordField, password);
        Log.log(Status.INFO, "Entered password into the password field.");
    }

    public void clickContinueWithEmail() {
        Click.usingElement(emailLoginButton);
        Log.log(Status.INFO, "Clicked on the \"Continue with Email\" button.");
    }
}
