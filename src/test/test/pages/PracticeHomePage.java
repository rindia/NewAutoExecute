package pages;

import com.sun.istack.internal.logging.Logger;
import framework.base.BasePage;
import framework.base.DriverContext;
import framework.controls.elements.HyperLink;
import framework.utilities.WebElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.PriorityQueue;

public class PracticeHomePage extends BasePage {

    @FindBy(how = How.XPATH,using=".//a[@class='login']")
    private WebElement GetTextOnHomePage;



    @FindBy(how = How.LINK_TEXT,using = "Sign inl")
    private HyperLink ClickSign;


    public boolean VerifyHomePageSignInButton()
    {
        return GetTextOnHomePage.isDisplayed();
    }

     public String VerifyHomepageTitle()
     {
         return DriverContext.Driver.getTitle();
     }


     public void ClickSignIn()
     {
             ClickSign.ClickLink();
     }
}
