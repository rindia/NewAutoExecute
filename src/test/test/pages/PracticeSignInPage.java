package pages;

import framework.base.BasePage;
import framework.controls.elements.Button;
import framework.controls.elements.TextBox;
import framework.utilities.WebDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeSignInPage extends BasePage {


    @FindBy(how = How.XPATH, using = ".//*[@class='breadcrumb clearfix']/span[@class='navigation_page']")
    private WebElement GetTextOnSignInPage;

    @FindBy(how = How.XPATH, using = "//*[@id='email_create']")
    private TextBox EmailIdforRegistration;

    @FindBy(how = How.XPATH, using = ".//*[@id='SubmitCreate']")
    private Button CreateAnAccount;

    @FindBy(how = How.XPATH, using = ".//*[@id='create_account_error']/ol/li[text()='Invalid email address.']")
    private WebElement ErrorMsgForEmail;


    @FindBy(how = How.XPATH, using = ".//*[@id='create_account_error']/ol/li")
    private WebElement ErrorMsgForExistingMail;

    @FindBy(how = How.XPATH,using = ".//*[@id='SubmitLogin']")
    private Button ClickSignInButton;

    @FindBy(how = How.XPATH,using = ".//*[@class='alert alert-danger']/ol/li[text()='An email address required.']")
    private WebElement ValidationMessageformailSign;

    @FindBy(how = How.XPATH,using = ".//*[@id='center_column']/div[1]/ol/li[text()='Password is required.']")
    private WebElement BlankPswdError;

    @FindBy(how = How.XPATH,using = ".//*[@id='center_column']/div[1]/ol/li[text()='Authentication failed.']")
    private WebElement AuthenticationFail;

    @FindBy(how = How.XPATH,using = ".//*[@id='email']")
    private TextBox Username;

    @FindBy(how = How.XPATH,using = ".//*[@id='passwd']")
    private TextBox Pass;


    public boolean VerifyTextSignInPage() {
        return GetTextOnSignInPage.isDisplayed();
    }

    public void verify_AcceptOnlyFreshMailID(String emailId) {
        WebDriverExtension.scrollingToElementofAPage(By.xpath("//*[@id='SubmitCreate']"));
        EmailIdforRegistration.EnterText(emailId);
        CreateAnAccount.PerformClick();
    }

    public void BlankEmailFieldandclickRegistrationButton() {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 200);

        CreateAnAccount.PerformClick();
    }

    public boolean ValidationMessagecome() {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 200);

        return ErrorMsgForEmail.isDisplayed();
    }

    public boolean ErrorExistingEmail() {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 200);

        return ErrorMsgForExistingMail.isDisplayed();
    }

    public void SignInErrorMessage()
    {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 170);
        ClickSignInButton.PerformClick();
        ValidationMessageformailSign.isDisplayed();
    }

    public void BlankPasswordError(String username)
    {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 170);
        Username.EnterText(username);
        ClickSignInButton.PerformClick();
        BlankPswdError.isDisplayed();
    }

    public void CheckAutth(String username,String password)
    {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 170);
        Username.clear();
        Username.EnterText(username);
        Pass.clear();
        Pass.EnterText(password);
        ClickSignInButton.PerformClick();
    }
    public void CheckAutthCorrect(String username,String password)
    {
        WebDriverExtension.scrollingByCoordinatesofAPage(0, 170);
        Username.clear();
        Username.EnterText(username);
        Pass.clear();
        Pass.EnterText(password);
        ClickSignInButton.PerformClick();
    }
}
