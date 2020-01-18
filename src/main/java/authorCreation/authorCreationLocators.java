package authorCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class authorCreationLocators {

    WebDriver driver;

    public authorCreationLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/users']")
    WebElement users;

    public WebElement clickOnUsers() {
        return users;
    }

    @FindBy(css = "a[href='/authors']")
    WebElement authors;

    public WebElement clickOnAuthors() {
        return authors;
    }

    @FindBy(css = "a[href='/authors/new']")
    WebElement addNewAuthorButton;

    public WebElement clickAddNewAuthorButton() {
        return addNewAuthorButton;
    }

    @FindBy(id = "metatagging_author_name")
    WebElement nameField;

    public WebElement clickNameField() {
        return nameField;
    }

    @FindBy(id = "metatagging_author_code")
    WebElement codeField;

    public WebElement clickCodeField() {
        return codeField;
    }

    @FindBy(id = "metatagging_author_alias")
    WebElement aliasField;

    public WebElement clickAliasField() {
        return aliasField;
    }

    @FindBy(id = "metatagging_author_alias")
    WebElement descriptionField;

    public WebElement clickdescriptionField() {
        return descriptionField;
    }

    @FindBy(name = "commit")
    WebElement saveButton;

    public WebElement clickSaveButton() {
        return saveButton;
    }

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    WebElement validation;

    public WebElement getValidation() { return  validation;}
}


