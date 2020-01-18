package questionAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class questionAssignmentLocators {

    WebDriver driver;

    public questionAssignmentLocators(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[href='/questions-assignment']")
    WebElement questionAssignment;

    @FindBy(xpath = "//body/div[@id='root']/div[@id='app']/div/div[@class='mock-test-div question-list-container']/div[@class='question-table-container']/div[@class='concept-table']/div[@class='ReactTable']/div[@class='rt-table']/div[@class='rt-tbody']/div[1]/div[1]/div[1]")
    WebElement checkBox1;

    @FindBy(xpath="//body/div[@id='root']/div[@id='app']/div/div[@class='mock-test-div question-list-container']/div[@class='question-table-container']/div[@class='concept-table']/div[@class='ReactTable']/d" +
            "iv[@class='rt-table']/div[@class='rt-tbody']/div[2]/div[1]/div[1]")
    WebElement checkBox2;

    @FindBy(xpath="//body/div[@id='root']/div[@id='app']/div/div[@class='mock-test-div question-list-container']/div[@class='question-table-container']/div[@class='concept-table']/div[@class='ReactTable']/div[@cla" +
            "ss='rt-table']/div[@class='rt-tbody']/div[3]/div[1]/div[1]")
    WebElement checkBox3;

    @FindBy(xpath = "//p[contains(text(),'Bulk Assignment')]")
    WebElement bulkAssignment;

    @FindBy(xpath = "//div[@class='pubilsh-modal']//div//div[contains(@class,'css-l7ww7r-control')]")
    WebElement selectUser;

    @FindBy(css = "[class='MuiDialogActions-root MuiDialogActions-spacing']>button:nth-of-type(2)")
    WebElement assign;

    @FindBy(xpath="//div[@class='rt-th']//div//input[@class='PrivateSwitchBase-input-399']")
    WebElement selectAll;

    @FindBy(xpath="//*[text()='Done']")
    WebElement doneButon;

    public  WebElement getDoneButon() { return  doneButon; }

    public WebElement getSelectAll() { return  selectAll; }

    public WebElement getAssign() { return assign; }

    public WebElement getSelectUser() {
        return selectUser;
    }

    public WebElement getbulkAssignment() {
        return bulkAssignment;
    }

    public WebElement getQuestionAssignment() {
        return questionAssignment;
    }

    public WebElement getCheckBox2() {
        return checkBox2;
    }

    public WebElement getCheckBox3() {
        return checkBox3;
    }

    public WebElement getCheckBox1() {
        return checkBox1;
    }



}
