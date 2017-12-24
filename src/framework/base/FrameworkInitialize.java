package framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class FrameworkInitialize extends Base {


    public static void InitializeBrowser(BrowserType browserType)
    {

        WebDriver driver = null;
        switch (browserType)
        {
            case Chrome:
            {
                System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case Firefox:
            {
                //Open the browser

               // System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
                driver= new FirefoxDriver();
                break;
            }
            case Edge:
            {


                System.setProperty("webdriver.edge.driver","E:\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
            case IE:
            {
                break;
            }
        }


        //Set the Driver
        DriverContext.setDriver(driver);
        //Browser
        DriverContext.Browser = new Browser(driver);

    }


}
