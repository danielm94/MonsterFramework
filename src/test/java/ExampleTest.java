import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shared_utilities.report_utility.TestReporter;
import ui.data_providers.login_page.LoginData;
import ui.page_objects.home_page.HomePage;
import ui.page_objects.login_page.LoginPage;
import ui.page_objects.profile_page.ProfilePage;
import ui.page_objects.profile_page.WorkExperiencePage;
import ui.utility.test_base.UITestBase;

@Listeners(UITestBase.class)
public class ExampleTest extends UITestBase {

    @Test(dataProviderClass = LoginData.class, dataProvider = "Login Info")
    @TestReporter(title = "Update Resume", description = "Log into monster account and update resume")
    public void test(String username, String password) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.clickAcceptAllCookies();
        homePage.clickProfileButton();

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isPageLoaded());
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickContinueWithEmail();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEditWorkExperienceButton(1);

        WorkExperiencePage workExperiencePage = new WorkExperiencePage();

        String newCompanyName = workExperiencePage.getCompanyName()
                                                  .equals("MedAvail Technologies Inc.") ?
                "MedAvail Technologies Inc" : "MedAvail Technologies Inc.";
        workExperiencePage.enterCompanyName(newCompanyName);
        workExperiencePage.clickSaveChangesButton();
        Assert.assertTrue(profilePage.isPageLoaded());
    }

    @Test
    @Parameters({"username", "password"})
    public void azureTest(String username, String password) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.clickAcceptAllCookies();
        homePage.clickProfileButton();

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isPageLoaded());
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickContinueWithEmail();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEditWorkExperienceButton(1);

        WorkExperiencePage workExperiencePage = new WorkExperiencePage();

        String newCompanyName = workExperiencePage.getCompanyName()
                                                  .equals("MedAvail Technologies Inc.") ?
                "MedAvail Technologies Inc" : "MedAvail Technologies Inc.";
        workExperiencePage.enterCompanyName(newCompanyName);
        workExperiencePage.clickSaveChangesButton();
        Assert.assertTrue(profilePage.isPageLoaded());
    }
}
