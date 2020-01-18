package users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userslocators {
    WebDriver driver;
    public userslocators(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[href='/users']")
    WebElement users;

    public WebElement clickOnUsers() {
        return users;
    }

    @FindBy(css="[class='form-group']>[id='search_name']")
    WebElement name;

    public WebElement clickOnNameField()
    {
        return name;
    }

    @FindBy(css = "[class='form-group']>[id='search_email']")
    WebElement emailField;

    public WebElement clickOnEmailField()
    {
        return emailField;
    }

    @FindBy(css = "[class='actions clearfix']")

    WebElement searchbtn;

    public WebElement clickOnSeachBtn()
    {
        return searchbtn;
    }

    @FindBy(css = "[href='/users/new']")
    WebElement registerNewExternalUser;

    public WebElement clickOnRegisterNewExternalUser()
    {
        return registerNewExternalUser;
    }

    @FindBy (css = "[id='user_first_name']")
    WebElement firstName;

    public WebElement clickOnFirstName(){
        return  firstName;
    }

    @FindBy(css = "[id='user_full_name']")
    WebElement fullName;

    public WebElement clickOnFullName()
    {
        return fullName;
    }

    @FindBy(css = "[id = user_designation]")
    WebElement designation;

    public WebElement clickOnDesignation(){
        return designation;
    }

    @FindBy(css = "[id='user_email']")
    WebElement emailfield;

    public WebElement clickOnEmail() {
        return  emailfield;
    }

    @FindBy(css = "[name='user[phone_number]']")
    WebElement phoneNumber;

    public  WebElement clickOnPhoneNumber()
    {
        return  phoneNumber;
    }

    @FindBy (css = "[name='commit']")
    WebElement save;

    public WebElement clickOnSaveBtn(){
        return save;
    }
}
