package framework.utilities;


import framework.base.DriverContext;
import framework.config.Settings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static String TakeScreenShot(String ScrenShotName) throws IOException {

        try {
            TakesScreenshot ts = (TakesScreenshot)DriverContext.Driver;
            File scrFile = ts.getScreenshotAs(OutputType.FILE);
            String dest = Settings.GetScreenShotPath+ScrenShotName+".png";
            File destination = new File(dest);
            FileUtils.copyFile(scrFile,destination);
            System.out.println("screen shot taken");
            return dest;
        }
       catch (Exception e)
       {
           System.out.println("Exception while getting screenshot"+e.getStackTrace());
           return e.getMessage();
       }
    }
}