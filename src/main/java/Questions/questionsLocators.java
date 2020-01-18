package Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class questionsLocators {
    WebDriver driver;

    public questionsLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "[href='/questions']")
    WebElement Questions;

    @FindBy(css = "[class='concept-new-btn-box']")
    WebElement createNewQuestions;

    @FindBy(css = "[id='mui-component-select-name']")
    WebElement type;

    @FindBy(css = "[id='Single Choice']")
    WebElement singleChoice;

    @FindBy(css = "[id='Multiple Choice']")
    WebElement multipleChoice;

    @FindBy(css = "[id='Integer']")
    WebElement integerType;

    @FindBy(xpath = "//*[text()='Subjective Numerical']")
    WebElement subjectiveNumericalType;

    @FindBy(xpath = "//*[text()='Subjective Answer']")
    WebElement subjectiveAnswerType;

    @FindBy(css = "[id='True False']")
    WebElement trueOrFalseType;

    @FindBy(css = "div[id='0']>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)")
    WebElement option1;

    @FindBy(css = "input[class='integer-subjective']")
    WebElement intergerOption;

    @FindBy(id = "Assertion")
    WebElement assertionOption;

    @FindBy(css = "div[id='1']>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)")
    WebElement option2;

    @FindBy(css = "div[id='2']>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)")
    WebElement option3;

    @FindBy(css = "div[id='3']>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)")
    WebElement option4;

    @FindBy(xpath = "//div[@class='question-details']/div[2]")
    WebElement questionEditor;

    @FindBy(css = "[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    WebElement questionEditorSection;

    @FindBy(css = "div[id='0']>div>div:nth-of-type(3)")
    WebElement slider;

    @FindBy(css = "div[id='0']>div>div:nth-of-type(5)>div>div>div")
    WebElement solutionStep;

    @FindBy(css = "span[class='cke_button_icon cke_button__blockquote_icon']")
    WebElement blockQuote;

    @FindBy(css = "[class='question-details-add-create-steps']")
    WebElement createStep;

    @FindBy(xpath = "//div[@class='type']//div//div[contains(@class,'css-l7ww7r-control')]")
    WebElement bookDropdown;

    @FindBy(xpath = "//div[contains(text(),'Syllabus')]")
    WebElement syllabus;

    @FindBy(xpath = "//*[text()='Book']")
    WebElement book;

    @FindBy(xpath = "//div[contains(text(),'Grade')]")
    WebElement grade;

    @FindBy(xpath = "//div[contains(text(),'Grade 5')]")
    WebElement grade5;


    @FindBy(css = "[class='exam-smart-tag-btn']>div:nth-of-type(1)")
    WebElement smartTag;

    @FindBy(id = "JEE Main")
    WebElement jeeMain;

    @FindBy(id = "NEET")
    WebElement NEET;

    @FindBy(css = "[class='exam-smart-tag-btn']>div:nth-of-type(2)>div")
    WebElement smartTagButton;

    @FindBy(css = "div[class='add-update-tag-button']>div:nth-of-type(1)")
    WebElement addTag;

    @FindBy(xpath = "//div[@class='content-grail-question-footer']/div/div[2]")
    WebElement statusDropdown;

    @FindBy(xpath = "//li[@id='Pending Approval']")
    WebElement pendingApproval;

    @FindBy(css = "[class='footer-add-choice fixed-positioning']>div:nth-of-type(3)")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='selection']//div//div[@class='css-bph5ye']")
    WebElement selection;

    @FindBy(xpath = "//div[contains(text(),'Test Book1 - 12345')]")
    WebElement testBook;

    @FindBy(xpath = "//div[contains(text(),'ICSE')]")
    WebElement ICSE;

    @FindBy(xpath = "//div[contains(text(),'Add Hints')]")
    WebElement hint;

    @FindBy(xpath = "//div[@class='hints-editor']//div[contains(@class,'editor-output')]")
    WebElement hintEditor;

    @FindBy(xpath = "//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps\" +\n" +
            "                \"-main')]//div[@class='topic-filters\" + \"']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")
    WebElement goalDropdown;

    @FindBy(xpath = "//*[text()='Engineering']")
    WebElement engineering;

    @FindBy(xpath = "//div[contains(text(),'Author')]")
    WebElement author;

    @FindBy(xpath = "//*[@class='meta-learning-container']/div[2]/div[3]/div[2]/div")
    WebElement examDropdown;

    @FindBy(xpath = "//*[@class='meta-learning-container']/div[2]/div[3]/div[3]/div")
    WebElement subjectDropdown;

    @FindBy(xpath = "//*[text()='JEE Main']")
    WebElement jeeMainFromDropDown;

    @FindBy(xpath = "//*[text()='Physics']")
    WebElement physics;

    @FindBy(xpath = "//div[contains(text(),'Tester')]")
    WebElement tester;

    @FindBy(id = "Subjective")
    WebElement subjectiveType;

    @FindBy(xpath = "//div[contains(text(),'Edition')]")
    WebElement edition;

    public WebElement getPhysics() { return physics; }

    public WebElement getassertionOption() { return assertionOption; }

    public WebElement getsubjective() { return subjectiveType; }

    public WebElement getJeeMainFromDropDown() { return jeeMainFromDropDown; }

    public WebElement getsubjectDropdown() { return  subjectDropdown;}

    public WebElement getExamDropdown() { return  examDropdown;}

    public  WebElement getEngineering() { return engineering;}

    public WebElement getGoal() { return goalDropdown; }

    public WebElement getaddTag() { return addTag; }

    public WebElement getAuthor() { return author; }

    public WebElement getTester() { return tester; }

    public WebElement getsmartTagButton() {
        return smartTagButton;
    }

    public WebElement getHintEditor() {
        return hintEditor;
    }

    public WebElement getstatusDropdown() {
        return statusDropdown;
    }

    public WebElement getsubmitButton() {
        return submitButton;
    }

    public WebElement getSelection() {
        return selection;
    }

    public WebElement gethint() {
        return hint;
    }

    public WebElement gettestBook() {
        return testBook;
    }

    public WebElement getgrade() {
        return grade;
    }

    public WebElement getGrade5() {
        return grade5;
    }

    public WebElement getICSE() {
        return ICSE;
    }

    public WebElement getpendingApproval() {
        return pendingApproval;
    }

    public WebElement getblockQuote() {
        return blockQuote;
    }

    public WebElement getsolutionStep() {
        return solutionStep;
    }

    public WebElement getoption1() {
        return option1;
    }

    public WebElement getintergerOption() {
        return intergerOption;
    }

    public WebElement getoption2() {
        return option2;
    }

    public WebElement getoption3() {
        return option3;
    }

    public WebElement getoption4() {
        return option4;
    }

    public WebElement getSlider() {
        return slider;
    }

    public WebElement getQuestionEditorSection() {
        return questionEditorSection;
    }

    public WebElement getSingleChoice() {
        return singleChoice;
    }

    public WebElement getmultipleChoice() {
        return multipleChoice;
    }

    public WebElement getintegerType() {
        return integerType;
    }

    public WebElement getsubjectiveNumericalType() {
        return subjectiveNumericalType;
    }

    public WebElement getsubjectiveAnswerType() {
        return subjectiveAnswerType;
    }

    public WebElement gettrueOrFalseType() {
        return trueOrFalseType;
    }

    public WebElement getType() {
        return type;
    }

    public WebElement getQuestions() {
        return Questions;
    }


    public WebElement getCreateNewQuestions() {
        return createNewQuestions;
    }

    public WebElement getsmartTag() {
        return smartTag;
    }

    public WebElement getjeeMain() {
        return jeeMain;
    }

    public WebElement getNEET() {
        return NEET;
    }

    public WebElement getbook() {
        return book;
    }

//    public WebElement getbook() {
//        return book;
//    }

    public WebElement getEdition() {
        return edition;
    }

    public WebElement getsyllabus() {
        return syllabus;
    }

    public WebElement getbookDropdown() {
        return bookDropdown;
    }

    public WebElement getcreateStep() {
        return createStep;
    }

}
