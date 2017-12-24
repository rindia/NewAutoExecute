package steps;


import com.aventstack.extentreports.ExtentTest;
import framework.base.DriverContext;
import framework.base.FrameworkInitialize;
import framework.config.ConfigReader;
import framework.config.Settings;
import framework.utilities.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;


public class TestInitialize extends FrameworkInitialize {
    //public static final ExtentReports reports = new ExtentReports("c:\\Reports\\test.html", true, DisplayOrder.OLDEST_FIRST);

    public ExtentTest logger;

    @BeforeSuite
    public void Initialize() throws IOException {

        //Initialize Config
        ConfigReader.PopulateSettings();

        //Logging
        Settings.Logs = new LogUtil();
        Settings.Logs.CreateLogFile();
        Settings.Logs.Write("Framework Initialize");

        //Create Test Cycle for Reporting
        Settings.ReportingConnection = DatabaseUtil.Open(Settings.ReportingConnectionString);
        ReportingUtil.CreateTestCycle(Settings.ReportingConnection);

        Settings.Logs.Write("Test Cycle Created");
        InitializeBrowser(Settings.BrowserType);
        DriverContext.Browser.Maximize();

        Settings.Logs.Write("Browser Initialized");
        DriverContext.Browser.GoToUrl(Settings.AUT);
        WebElementExtension.WaitConditions();
        Settings.Logs.Write("Navigated to URL " + Settings.AUT);

        try {
            ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (Exception e) {
        }

    }

//    @AfterMethod
//    public void TearDown(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String path = Screenshot.TakeScreenShot(result.getName());
//            String img = logger.addScreenCapture(path);
//            //  Throwable th = result.getThrowable();
//            logger.log(LogStatus.FAIL, "Failed " + result.getName(), result.getTestName() + img);
//        }
//        reports.endTest(logger);
//        reports.flush();
//    }

    @AfterSuite
    public void close() {
        DriverContext.Driver.quit();
    }
}
