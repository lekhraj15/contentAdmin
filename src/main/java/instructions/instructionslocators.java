package instructions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class instructionslocators {

    WebDriver driver;

    public instructionslocators(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[class='search-metrics']>div:nth-of-type(1)>div:nth-of-type(2)>div>div>input")
    WebElement idField;

    public WebElement clickOnIdField(){
        return idField;
    }

    @FindBy(css = "[class='search-metrics']>div:nth-of-type(2)>div:nth-of-type(2)>div>div>input")
    WebElement nameField;

    public WebElement clickOnNameField() {
        return  nameField;
    }

    @FindBy(css= "[href='/instruction']")
    WebElement instruction;

    @FindBy(xpath = "//div[@class='search-button-div']//p[contains(text(),'Search')]")
    WebElement validationMessage;

    public  WebElement clickOnValidationMessage() {return validationMessage;}

    public WebElement clickOnInstruction() {
        return  instruction;
    }

    @FindBy(css= "[class='search-button-div']")
    WebElement searchBtn;

    @FindBy(css = "[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    WebElement description;

    public WebElement clickOndescription() {
        return  description;
    }

    public WebElement clickOnSearchBtn() {
        return  searchBtn;
    }

    @FindBy(css="[class='concept-new-btn-box']")
    WebElement createNewInstruction;

    public WebElement clickOnCreateNewInstruction(){
        return createNewInstruction;
    }

    @FindBy(css = "[id='outlined-dense']")
    WebElement createNewName;

    public WebElement clickOnNewName()
    {
        return createNewName;
    }

    @FindBy(css = "[label='Save']")
    WebElement saveBtn;

    public WebElement clickOnSaveBtn()
    {
        return saveBtn;
    }
}
