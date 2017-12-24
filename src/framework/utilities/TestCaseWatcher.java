package framework.utilities;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.base.DriverContext;

import framework.config.Settings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class TestCaseWatcher extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult var1) {
         ExtentUtil.fetchTest().pass(MarkupHelper.createLabel("Status:Passed", ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            File srcimg = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcimg,new File("images/"+result.getMethod().getMethodName()+".png"));
            ExtentUtil.fetchTest().fail("FAILED  "+result.getMethod().getMethodName()+result.getThrowable().getMessage() ,MediaEntityBuilder.createScreenCaptureFromPath("images/"+result.getMethod().getMethodName()+".png").build());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult var1) {

         ExtentUtil.SkipTest(var1.getMethod().getMethodName());

    }

    @Override
    public void onStart(ITestContext var1) {
        ExtentUtil.createReporter(Settings.ReportFileName);
    }

    @Override
    public void onFinish(ITestContext var1) {

        ExtentUtil.saveReporter();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentUtil.createTest(result.getMethod().getMethodName());
    }

}
