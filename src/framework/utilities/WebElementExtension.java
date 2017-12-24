package framework.utilities;


import framework.base.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElementExtension {

    public static void Hover(WebElement element) throws InterruptedException {
        Actions actions = new Actions(DriverContext.Driver);
        actions.moveToElement(element).perform();

    }
    public static void WaitConditions()
    {
        DriverContext.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public static WebElement getWhenVisible(By locator, int timeout)
    {

        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(DriverContext.Driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;

    }

    public static void clickLinkByTextName(By locator,String linktextName) throws InterruptedException {
        List<WebElement> list = DriverContext.Driver.findElements(locator);
      //  List<WebElement> list = DriverContext.Driver.findElements(By.xpath("//*[@id='nav']/ol/li/a"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals(linktextName))
            {
                list.get(i).click();
                break;
            }

        }
    }


}
