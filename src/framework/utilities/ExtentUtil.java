package framework.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ExtentUtil {

    static ExtentReports extentReports = null;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    public static ExtentReports createReporter(String filename) {
        //HTML Reporter
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(filename);
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setReportName("Test cases Reports");
        extentHtmlReporter.config().setChartVisibilityOnOpen(true);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //System info
        try {
            extentReports.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
            extentReports.setSystemInfo("IP Address", InetAddress.getLocalHost().getHostAddress());
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return extentReports;
    }

    public static void saveReporter() {
        if (extentReports != null) {
            extentReports.flush();

        }
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    public static synchronized ExtentTest createTest(String testname) {
        ExtentTest extentTest = extentReports.createTest(testname);
        extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
        return extentTest;
    }


    public static synchronized ExtentTest SkipTest(String testname) {
        ExtentTest extentTest = extentReports.createTest(testname);
        extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
        return extentTest;
    }

    public static synchronized ExtentTest createTest(String testname, String Desc) {
        ExtentTest extentTest = extentReports.createTest(testname, Desc);
        extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
        return extentTest;
    }

    public static synchronized ExtentTest fetchTest() {

        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }

    public static synchronized void TestDescription(String description) {
        fetchTest().log(Status.INFO, MarkupHelper.createLabel(description, ExtentColor.BLACK));

    }


}
