package publicationCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class publicationCreatorLocators {
    WebDriver driver;

    public publicationCreatorLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/publications']")
    WebElement publicationTab;

    public WebElement getPublicationTab() {
        return publicationTab;
    }

    @FindBy(css = "[href='/publications/new']")
    WebElement addNewPublication;

    public WebElement getAddNewPublication(){
        return addNewPublication;
    }

    @FindBy(id = "metatagging_publication_name")
    WebElement nameField;

    public WebElement clickNameField() {
        return nameField;
    }

    @FindBy(id = "metatagging_publication_code")
    WebElement codeField;

    public WebElement clickCodeField() {
        return codeField;
    }

    @FindBy(id = "metatagging_publication_address")
    WebElement addressField;

    public WebElement clickAddressField() {
        return addressField;
    }

    @FindBy(id = "metatagging_publication_description")
    WebElement descriptionField;

    public WebElement clickdescriptionField() {
        return descriptionField;
    }

    @FindBy(name = "commit")
    WebElement saveButton;

    public WebElement clickSaveButton() {
        return saveButton;
    }

    @FindBy(id = "metatagging_publication_phone_no")
    WebElement contactNumberField;

    public WebElement clickContactNumber() {
        return contactNumberField;
    }

    @FindBy(id = "select2-metatagging_publication_country-container")
    WebElement countryField;


    public WebElement clickCountryField() {
        return countryField;
    }

    @FindBy(className = "select2-search__field")
    WebElement searchField;

    public WebElement getSearchField() {
        return searchField;
    }


    @FindBy (xpath = "//*[text()='India']")
    WebElement india;

    public WebElement getIndia() {
        return india;
    }
    @FindBy(css = "[href='/users']")
    WebElement users;

    public WebElement clickOnUsers() {
        return users;
    }

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    WebElement validation;

    public WebElement getValidation() { return  validation;}
}
