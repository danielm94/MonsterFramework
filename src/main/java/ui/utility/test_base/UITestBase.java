package ui.utility.test_base;


import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.FrameworkPropertyFile;
import shared_utilities.report_utility.*;
import ui.utility.driver.Driver;

import java.io.IOException;

public class UITestBase extends TestListenerAdapter {
    protected static String baseUrl;
    protected static ThreadLocal<Boolean> reportsEnabled = new ThreadLocal<>();

    @BeforeClass
    public void beforeClass() {
        baseUrl = PropertyReader.getProperty(FrameworkPropertyFile.APPLICATION_PROPERTIES, "site.url");
    }

    @Parameters(value = {"browser"})
    @BeforeMethod
    public void beforeMethod(@Optional String browser) {
        Driver.getInstance()
              .setDriver(browser);
        Driver.getInstance()
              .getDriver()
              .get(baseUrl);
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        Driver.getInstance()
              .quit();
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.getInstance()
                .flushReport();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (reportsEnabled.get()) {
            Log.log(Status.FAIL, result.getMethod()
                                       .getMethodName() + " has failed.");
            ThreadLocal<String> screenshotFile = new ThreadLocal<>();
            try {
                screenshotFile.set(Screenshot.captureBrowser(Driver.getInstance()
                                                                   .getDriver(),
                        Reporter.getInstance()
                                .getReportDirectory(),
                        result.getMethod()
                              .getMethodName() + "_" + TimeStamp.getTimeStamp() + "_FAILURE"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.addScreenshotFromPath(screenshotFile.get(), "Screenshot of browser on failure");
            if (result.getThrowable() != null) {
                Log.log(Status.FAIL, result.getThrowable());
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        reportsEnabled.set(result.getMethod()
                                 .getConstructorOrMethod()
                                 .getMethod()
                                 .getAnnotation(TestReporter.class) != null);
        TestReport.getInstance()
                  .setTestReportsEnabled(reportsEnabled.get());
        if (reportsEnabled.get()) {
            Reporter.getInstance()
                    .setupReporter(result.getMethod()
                                         .getRealClass()
                                         .getName());
            ThreadLocal<String> testReportTitle = new ThreadLocal<>();
            testReportTitle.set(result.getMethod()
                                      .getConstructorOrMethod()
                                      .getMethod()
                                      .getAnnotation(TestReporter.class)
                                      .title());
            ThreadLocal<String> testReportDescription = new ThreadLocal<>();
            testReportDescription.set(result.getMethod()
                                            .getConstructorOrMethod()
                                            .getMethod()
                                            .getAnnotation(TestReporter.class)
                                            .description());
            TestReport.getInstance()
                      .createTestReport(testReportTitle.get(), testReportDescription.get());
            TestReport.getInstance()
                      .assignTestCategories(result.getMethod()
                                                  .getGroups());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.log(Status.PASS, "Great success!");
    }

    public void debugSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
