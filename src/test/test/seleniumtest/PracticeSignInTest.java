package seleniumtest;

import framework.utilities.ExtentUtil;
import org.testng.annotations.Test;
import pages.PracticeSignInPage;
import steps.TestInitialize;

public class PracticeSignInTest extends TestInitialize {


    @Test(description = "verify that sign in and text page is coming and ")
    public void Verify_txt_On_SignInPage() {


        CurrentPage = CurrentPage.GetInstance(PracticeSignInPage.class);
        CurrentPage.As(PracticeSignInPage.class).VerifyTextSignInPage();
    }

    @Test(description = "Show error message in email id field is blank on click registration button")
    public void Verify_EmailValidation() {
        CurrentPage.As(PracticeSignInPage.class).BlankEmailFieldandclickRegistrationButton();
    }

    @Test(description = "verify validation message should come if existing mail is entered")
    public void Verify_Existing_MailId_Error() {
        CurrentPage.As(PracticeSignInPage.class).ErrorExistingEmail();
    }

    @Test(description = "verify that validation mail error if field is blank, click on signIn Button")
    public void VerifyBlankMailerrorSignInButton() {
        CurrentPage.As(PracticeSignInPage.class).ErrorExistingEmail();
    }

    @Test(description = "verify validation message should come if password field is blank, click on SignIn Button")
    public void VerifyBlankPaswderrorSignInButton() {
        CurrentPage.As(PracticeSignInPage.class).BlankPasswordError("rohit.saini.uk@gmail.com");
    }

    @Test(description = "Authentication validation ")
    public void NegativeAuth() {
        CurrentPage.As(PracticeSignInPage.class).CheckAutth("asdasd@gmail.com", "saini");
    }

    @Test(description = "Veirfy positive login functionality")
    public void PositiveLogin() {
        CurrentPage.As(PracticeSignInPage.class).CheckAutthCorrect("rohit.saini.uk@gmail.com", "sainix");
    }
}
