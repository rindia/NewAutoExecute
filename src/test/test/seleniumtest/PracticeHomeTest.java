package seleniumtest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import framework.utilities.ExtentUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeHomePage;
import steps.TestInitialize;


public class PracticeHomeTest extends TestInitialize {

    @Test(description="Verify page is open and title")
    public void verifyPageTitle() {
        ExtentUtil.TestDescription("Verify Home Page Title");
        CurrentPage =  GetInstance(PracticeHomePage.class);
        String Title = CurrentPage.As(PracticeHomePage.class).VerifyHomepageTitle();
        Assert.assertEquals(Title, "My gStore");


    }

    @Test(description = "Verify Sign In Link is Present in home page")
    public void Verify_SignIn_Link_Is_Dispalyed_HomePage() throws InterruptedException {
        CurrentPage.As(PracticeHomePage.class).VerifyHomePageSignInButton();
    }

    @Test
    public void Click_SignIn_Link()
    {
        ExtentUtil.fetchTest().log(Status.INFO, MarkupHelper.createCodeBlock("rohit saini..hkjhkjhkj..........."));
        CurrentPage.As(PracticeHomePage.class).ClickSignIn();

    }
}
