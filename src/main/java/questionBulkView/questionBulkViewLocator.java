package questionBulkView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class questionBulkViewLocator {
    WebDriver driver;

    public questionBulkViewLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/questions/view']")
    WebElement questionBulkView;


    @FindBy(css = "[class='mock-test-div']>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div>input")
    WebElement questionCode;


    @FindBy(css = "[class='mock-test-div']>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div>input")
    WebElement questionID;


    public WebElement clickOnQuestionID() {
        return questionID;
    }

    public WebElement clickOnQuestionBulkView() {
        return questionBulkView;
    }

    public WebElement clickOnQuestionCode() {
        return questionCode;
    }


}
