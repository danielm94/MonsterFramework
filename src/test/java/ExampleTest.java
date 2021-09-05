import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import shared_utilities.report_utility.TestReportInformation;
import ui.page_objects.home_page.HomePage;
import ui.utility.test_base.UITestBase;

@Listeners(UITestBase.class)
public class ExampleTest extends UITestBase {

    @Test
    @TestReportInformation(title = "Update Resume", description = "Log into monster account and update resume")
    public void test() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.clickProfileButton();
    }
}
