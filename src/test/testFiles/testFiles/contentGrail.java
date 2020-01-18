package testFiles;

import authorCreation.authorCreationLocators;
import books.booksLocators;
import com.github.javafaker.Faker;
import instructions.instructionslocators;
import loginModule.loginLocators;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import publicationCreation.publicationCreatorLocators;
import questionAssignment.questionAssignmentLocators;
import questionBulkView.questionBulkViewLocator;
import resources.resource;
import users.userslocators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class contentGrail {
    WebDriver driver;
    resource re = new resource();
    Random rand = new Random();
    Faker faker = new Faker();

    @BeforeMethod
    public void login() throws InterruptedException, IOException {
        File src = new File("C:\\Users\\Indium Software\\IdeaProjects\\mavencontentGrail\\config\\Configuration.properties");
        FileInputStream fis = new FileInputStream(src);
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.setProperty("webdriver.chrome.driver", prop.getProperty("path"));
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginLocators lo = new loginLocators(driver);
        lo.getSignIn().click();
        lo.getEmail().sendKeys(username);
        lo.getPassword().sendKeys(password);
        lo.getPassword().sendKeys(Keys.ENTER);
        WebElement element = driver.findElement(By.cssSelector("[href='/questions']"));
        Boolean value = element.isDisplayed();
        re.explicitWait(driver, element, 15);
        Assert.assertEquals(element.isDisplayed(), true);

    }

    public void logOut() throws InterruptedException, IOException {
        loginLocators lo = new loginLocators(driver);
        lo.getProfile().click();
//        Thread.sleep(3000);
//        lo.getEditProfile().click();
//        Thread.sleep(3000);
//        lo.getProfiledropdown().click();
        Thread.sleep(3000);
        lo.getLogOut().click();
        String Actual = "https://new-content-admin-staging.embibe.com/";
        String Expected = driver.getCurrentUrl();
        Assert.assertEquals(Actual, Expected);

    }

    @Test
    public void questionAssignment() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        questionAssignmentLocators questionAssignmentLocators = new questionAssignmentLocators(driver);
        questionAssignmentLocators.getQuestionAssignment().click();
        Thread.sleep(3000);
        re.scrollDown(driver, 250);
        questionAssignmentLocators.getCheckBox1().click();
        questionAssignmentLocators.getCheckBox2().click();
        questionAssignmentLocators.getCheckBox3().click();
        // questionAssignmentLocators.getSelectUser().click();
        Thread.sleep(3000);
        questionAssignmentLocators.getbulkAssignment().click();
        Thread.sleep(5000);
        questionAssignmentLocators.getSelectUser().click();
        String xpath = "//*[contains(text(),'cg02 tester')]";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(5000);
        questionAssignmentLocators.getAssign().click();
        Thread.sleep(3000);
        WebElement element = questionAssignmentLocators.getDoneButon();
        //re.explicitWait(driver, element, 20);
        String failure = driver.findElement(By.cssSelector("[class='bulk-assignment-count-details']>div:nth-of-type(2)")).getText();
        Thread.sleep(3000);
        System.out.println(failure);
        if (failure.contains("0")) {
            System.out.println("Bulk Questions assigned Successfully");
        } else {
            System.out.println("Some Questions not assigned");
        }
        element.click();

    }

    //Bulk view search through Question ID
    @Test
    public void questionID() throws IOException, InterruptedException {
        resource re = new resource();
        questionBulkViewLocator questionBulkView = new questionBulkViewLocator(driver);
        re.explicitWait(driver, questionBulkView.clickOnQuestionBulkView(), 20);
        questionBulkView.clickOnQuestionBulkView().click();
        re.explicitWait(driver, questionBulkView.clickOnQuestionID(), 20);
        questionBulkView.clickOnQuestionID().sendKeys("10007801 10007799 10007750");
        questionBulkView.clickOnQuestionID().sendKeys(Keys.ENTER);

    }
    //Bulk view search through Question Code

    @Test
    public void questionCode() throws IOException, InterruptedException {
        Thread.sleep(3000);
        questionBulkViewLocator questionBulkView = new questionBulkViewLocator(driver);
        questionBulkView.clickOnQuestionBulkView().click();
        questionBulkView.clickOnQuestionCode().sendKeys("EM10007801 EM10007799 EM10007750");
        questionBulkView.clickOnQuestionID().sendKeys(Keys.ENTER);

    }

    //New Users creation
    @Test
    public void Users() throws IOException, InterruptedException {
        String Firstname = faker.name().firstName();
        String Fullname = faker.name().fullName();
        String Designation = faker.name().prefix();
        String phoneNumber = faker.number().digits(10);
        resource re = new resource();
        Thread.sleep(3000);
        userslocators users = new userslocators(driver);
        re.scrollIntoView(driver, users.clickOnUsers());
        Thread.sleep(3000);
        users.clickOnUsers().click();
        Thread.sleep(3000);
        File src = new File(System.getProperty("user.dir") + "\\config\\Configuration.properties");
        FileInputStream fis = new FileInputStream(src);
        Properties prop = new Properties();
        prop.load(fis);
        String filepath = prop.getProperty("excelpath");
        FileInputStream fp = new FileInputStream(filepath);
        XSSFWorkbook wb = new XSSFWorkbook(fp);
        XSSFSheet sh = wb.getSheetAt(1);
        Random rand = new Random();
        Thread.sleep(3000);
        users.clickOnRegisterNewExternalUser().click();
        Thread.sleep(3000);
        users.clickOnFirstName().sendKeys(Firstname);
        users.clickOnFullName().sendKeys(Fullname);
        users.clickOnDesignation().sendKeys(Designation);
        users.clickOnEmail().sendKeys(Firstname + "@gmail.com");
        users.clickOnPhoneNumber().sendKeys(phoneNumber);
        users.clickOnSaveBtn().click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).
                isDisplayed(), true);
    }

    @Test
    public void instructions() throws InterruptedException {
        instructionslocators instructionslocators = new instructionslocators(driver);
        Thread.sleep(3000);
        instructionslocators.clickOnInstruction().click();
        Thread.sleep(3000);
        instructionslocators.clickOnCreateNewInstruction().click();
        Thread.sleep(3000);
        String Title = RandomStringUtils.random(10, "Random Instruction Title for Testing Purpose");
        instructionslocators.clickOnNewName().sendKeys(Title);
        Thread.sleep(3000);
        instructionslocators.clickOnNewName().sendKeys(Keys.TAB);
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        String instructiondetails = RandomStringUtils.random(25, "Embibe Test Papers for Testing Only");
        instructionslocators.clickOndescription().sendKeys(instructiondetails);
        driver.switchTo().defaultContent();
        instructionslocators.clickOnSaveBtn().click();
        String result = instructionslocators.clickOnValidationMessage().getText();
        if (result.contains("Search")) {
            System.out.println("Instruction is created");
        } else {
            System.out.println("Error while creating Instruction");
        }
    }

    @Test
    public void authorPublication() throws InterruptedException {
        resource re = new resource();
        authorCreationLocators authorCreationLocators = new authorCreationLocators(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        re.scrollDown(driver, 250);
        authorCreationLocators.clickOnUsers().click();
        re.scrollIntoView(driver, authorCreationLocators.clickOnAuthors());
        authorCreationLocators.clickOnAuthors().click();
        String name = faker.book().author();
        String code = faker.number().digits(10);
        String alias = faker.university().name();
        Thread.sleep(3000);
        authorCreationLocators.clickAddNewAuthorButton().click();
        Thread.sleep(2000);
        authorCreationLocators.clickNameField().sendKeys(name);
        authorCreationLocators.clickCodeField().sendKeys(code);
        authorCreationLocators.clickAliasField().sendKeys(alias);
        authorCreationLocators.clickSaveButton().click();
        Assert.assertEquals(authorCreationLocators.getValidation().isDisplayed(), true);

    }

    @Test
    public void publicationCreation() throws IOException, InterruptedException {
        resource re = new resource();
        Random rand = new Random();
        publicationCreatorLocators publicationCreatorLocators = new publicationCreatorLocators(driver);
        re.scrollDown(driver, 250);
        publicationCreatorLocators.clickOnUsers().click();
        re.scrollIntoView(driver, publicationCreatorLocators.getPublicationTab());
        publicationCreatorLocators.getPublicationTab().click();
        List<String> givenList = Arrays.asList("India", "Afghanistan", "Australia", "Malaysia");
        //for (int i = 0; i <= 3; i++) {
        Thread.sleep(2000);
        publicationCreatorLocators.getAddNewPublication().click();
        Thread.sleep(2000);
        String publicationname = faker.book().publisher();
        String code = faker.number().digits(10);
        String address = faker.address().streetAddress();
        String contactNumber = faker.number().digits(10);
        int randomIndex = rand.nextInt(givenList.size());
        String SearchField = givenList.get(randomIndex);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        publicationCreatorLocators.clickNameField().sendKeys(publicationname);
        publicationCreatorLocators.clickCodeField().sendKeys(code);
        publicationCreatorLocators.clickdescriptionField().sendKeys(publicationname);
        publicationCreatorLocators.clickAddressField().sendKeys(address);
        publicationCreatorLocators.clickContactNumber().sendKeys(contactNumber);
        publicationCreatorLocators.clickCountryField().click();
        publicationCreatorLocators.getSearchField().sendKeys((CharSequence) SearchField);
        Thread.sleep(2000);
        String xpath = "//*[text()='" + SearchField + "']";
        driver.findElement(By.xpath((xpath))).click();
        publicationCreatorLocators.clickSaveButton().click();
        Assert.assertEquals(publicationCreatorLocators.getValidation().isDisplayed(), true);

    }

    @Test
    public void createNewBook() throws IOException, InterruptedException {
        resource re = new resource();
        Thread.sleep(3000);
        booksLocators books = new booksLocators(driver);
        //   WebElement element = driver.findElement(By.cssSelector("[href='/books']"));
        re.scrollIntoView(driver, books.clickOnBooks());
        Thread.sleep(3000);
        books.clickOnBooks().click();
        List<String> grade = Arrays.asList("LKG/K1,UKG/K2,Nursery/Pre-K,Grade 12, Grade 11,Grade 10,Grade 9, Grade 8, Grade 7, Grade 6, Grade 5,Grade 4, Grade 3, Grade 2, Grade 1");
        List<String> syllabus = Arrays.asList("ICSE", "CBSE", "IB", "NGSS", "Banking", "Railway");
        List<String> language = Arrays.asList("English", "Hindi", "Tamil", "Telugu", "French", "Kannada");
        List<String> subject = Arrays.asList("Physics", "Chemistry", "Biology", "Mathematics","Zoology", "Science");
        List<String> author = Arrays.asList("Tester 1", "Author 1", "Author 2", "Automation Script", "Embibe Publications", "Testing123 Publications");
        List<String> pub = Arrays.asList("Test6 publication", "Books on Automation Testing", "Test Publication", "Books on Manual Testing", "Learn Manual Testing", "Development publication Embibe");
        List<String> authors = Arrays.asList("Author 1 ( Author 1 )", "Aggarwal R. S. 7630 ( Agarwal )", "Aggarwal R. S. 43011416 ( Agarwal )", "Aggarwal R. S. 27853627 ( Agarwal )", "Aggarwal R. S. 73758599 ( Agarwal )");
        for (int i = 0; i < 1; i++) {
            String name = RandomStringUtils.random(6, "ContentGrail");
            int authorslist = rand.nextInt(authors.size());
            String Authors = author.get(authorslist);
            int randomIndex = rand.nextInt(grade.size());
            String Grade = grade.get(randomIndex);
            String Edition = RandomStringUtils.random(4, "2019");
            String ISBNCode = RandomStringUtils.random(13, "899999999999");
            int syl = rand.nextInt(syllabus.size());
            String Syllabuses = syllabus.get(syl);
            int lang = rand.nextInt(language.size());
            String BookLanguages = language.get(lang);
            int sub = rand.nextInt(subject.size());
            String BookSubjects = subject.get(sub);
            String BookCode = RandomStringUtils.random(5, "12345");
            Thread.sleep(3000);
            books.clickOnAddNewBook().click();
            Thread.sleep(3000);
            books.clickOnName().sendKeys(name);
            Thread.sleep(3000);
            books.clickOnAuthor().sendKeys(Authors);
            int authorsname = rand.nextInt(authors.size());
            String authorlist = authors.get(authorsname);
            Thread.sleep(3000);
            books.clickOnPublications().click();
            //publication selection
            Thread.sleep(3000);
            int publist = rand.nextInt(pub.size());
            String publications = pub.get(publist);
            String num = RandomStringUtils.random(1, "9");
            //books.clickOnPublications().sendKeys(publications);
            //String publications = name;
            driver.findElement(By.cssSelector("[id='select2-metatagging_book_publication-results']>li:nth-of-type(" + num + ")")).click();
            Thread.sleep(3000);
            books.clickOnAuthor().sendKeys(authorlist);
            books.clickOnGrade().sendKeys(Grade);
            books.clickOnISBN().click();
            books.clickOnISBN10().click();
            books.clickOnISBNCode().sendKeys(ISBNCode);
            Thread.sleep(3000);
            books.clickOnSyllabuses().sendKeys(Syllabuses);
            Thread.sleep(3000);
            books.clickOnBookLanguage().sendKeys(BookLanguages);
            books.clickOnBookCode().sendKeys(BookCode);
            books.clickOnBookSubjects().sendKeys(BookSubjects);
            re.scrollDown(driver, 250);
            books.clickOnEdition().sendKeys(Edition);
            books.clickOnSaveButton().click();

        }

    }

    @AfterMethod
    public void tearDown() throws IOException, InterruptedException {
        // logOut();
        driver.close();
    }
}



