package framework.utilities;


import framework.base.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class WebDriverExtension {


    public static void scrollingByCoordinatesofAPage(int x, int y)
    {
        ((JavascriptExecutor) DriverContext.Driver).executeScript("window.scrollBy("+x+","+y+")");
    }

    public static void scrollingToBottomofAPage()
    {

        ((JavascriptExecutor) DriverContext.Driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollingToElementofAPage(By locator) {


        ((JavascriptExecutor) DriverContext.Driver).executeScript(
                "arguments[0].scrollIntoView();", DriverContext.Driver.findElement(locator));
    }

}
