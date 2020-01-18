package books;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class booksLocators {
    WebDriver driver;

    public booksLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/books']")
    WebElement books;
    @FindBy(css = "[href='/books/new']")
    WebElement addnewbooks;
    @FindBy(css = "[name='metatagging_book[name]']")
    WebElement name;
    @FindBy(css = "[id='metatagging_book_authors']")
    WebElement Author;
    @FindBy(css = "[id='metatagging_book_grade']")
    WebElement grade;
    @FindBy(css = "[class='ibox-content']>div>div>div>div:nth-of-type(2)>div:nth-of-type(1)>div")
    WebElement publication;
    @FindBy(css = "[id='metatagging_book_edition']")
    WebElement edition;
    @FindBy(css = "[id='metatagging_book_isbn_type']")
    WebElement ISBN;
    @FindBy(css = "[id='metatagging_book_isbn_type']>option:nth-of-type(2)")
    WebElement ISBN10;
    @FindBy(css = "[id='metatagging_book_isbn_type']>option:nth-of-type(3)")
    WebElement ISBN13;
    @FindBy(css = "[id='metatagging_book_isbn_code']")
    WebElement ISBNcode;
    @FindBy(css = "[id='metatagging_book_code']")
    WebElement bookCode;
    @FindBy(css = "[id='metatagging_book_syllabuses']")
    WebElement syllabuses;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(2)")
    WebElement icseSyllabuses;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(1)")
    WebElement cbseSyllabuses;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(3)")
    WebElement igcseSyllabuses;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(4)")
    WebElement ibSyllabuses;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(5)")
    WebElement commonCore;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(6)")
    WebElement ngss;
    @FindBy(css = "[class='select2-results__options']>li:nth-of-type(7)")
    WebElement sg;
    @FindBy(css = "[id='metatagging_book_languages']")
    WebElement bookLanguage;
    @FindBy(css = "[id='metatagging_book_subjects']")
    WebElement bookSubjects;
    @FindBy(css = "[value='Save']")
    WebElement save;


    public WebElement clickOnBooks() {
        return books;
    }

    public WebElement clickOnAddNewBook() {
        return addnewbooks;
    }

    public WebElement clickOnName() {
        return name;
    }

    public WebElement clickOnAuthor() {
        return Author;
    }

    public WebElement clickOnGrade() {
        return grade;
    }

    public WebElement clickOnPublications() {
        return publication;
    }

    public WebElement clickOnEdition() {
        return edition;
    }

    public WebElement clickOnISBN() {
        return ISBN;
    }

    public WebElement clickOnISBN10() {
        return ISBN10;
    }

    public WebElement clickOnISBN13() {
        return ISBN13;
    }

    public WebElement clickOnISBNCode() {
        return ISBNcode;
    }

    public WebElement clickOnBookCode() {
        return bookCode;
    }

    public WebElement clickOnSyllabuses() {
        return syllabuses;
    }

    public WebElement clickOnICSESyllabuses() {
        return icseSyllabuses;
    }

    public WebElement clickOnCBSESyllabuses() {
        return cbseSyllabuses;
    }

    public WebElement clickOnIGCSESyllabuses() {
        return igcseSyllabuses;
    }

    public WebElement clickOnIBSyllabuses() {
        return ibSyllabuses;
    }

    public WebElement clickOnCommonCore() {
        return commonCore;
    }

    public WebElement clickOnNGSS() {
        return ngss;
    }

    public WebElement clickOnSG() {
        return sg;
    }

    public WebElement clickOnBookLanguage() {
        return bookLanguage;
    }

    public WebElement clickOnBookSubjects() {
        return bookSubjects;
    }

    public WebElement clickOnSaveButton() {
        return save;
    }

}



