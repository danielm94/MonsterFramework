package ui.page_objects.home_page;

import org.openqa.selenium.support.PageFactory;
import ui.utility.driver.Driver;
import ui.utility.page_object_utils.PageObject;

public final class LoginPage implements PageObject {

    public LoginPage() {
        PageFactory.initElements(Driver.getInstance()
                                       .getDriver(), this);
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }

    @Override
    public void navigateToPage() {

    }

    @Override
    public boolean isPageTitleValid(String title) {
        return false;
    }
}
