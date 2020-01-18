package loginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginLocators {
    WebDriver driver;

    public loginLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class='button-signin']")
    WebElement signIn;

    @FindBy(css = "input[name='email']")
    WebElement email;

    @FindBy(css = "input[name='password']")
    WebElement password;

//    //@FindBy(css="button[class='MuiButtonBase-root-47 MuiButton-root-219 MuiButton-contained-230 MuiButton-containedSecondary-232 MuiButton-raised-233 MuiButton-raisedSecondary-235 MuiButton-sizeLarge-243 btn-half-width']")
//    WebElement login;
//    public WebElement login()
//    {
//        return  login;
//    }

   @FindBy(xpath ="//span[contains(text(),'Forgot password?')]")
    WebElement forgotPassword;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd']")
    WebElement profile;

    @FindBy(xpath = "//li[contains(text(),'Edit Profile')]")
    WebElement editProfile;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    WebElement profiledropdown;

    @FindBy(xpath = "//li[contains(text(),'Logout')]")
    WebElement logOut;

    @FindBy(css = "[type='email']")
    WebElement resetemail;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained btn-half-width" +
            " margin-top-20 MuiButton-containedSecondary MuiButton-containedSizeLarge MuiButton-sizeLarge']")
    WebElement submit;

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getProfiledropdown() {
        return profiledropdown;
    }

    public WebElement getResetemail() {
        return resetemail;
    }

    public WebElement getLogOut() {
        return logOut;
    }

    public WebElement getEditProfile() {
        return editProfile;
    }


    public WebElement getProfile() {
        return profile;
    }

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

}
