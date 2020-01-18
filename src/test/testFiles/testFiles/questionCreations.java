package testFiles;

import Questions.questionsLocators;
import books.booksLocators;
import loginModule.loginLocators;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import resources.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class questionCreations {

    WebDriver driver;
    Random rand = new Random();

    @Test
    public void login() throws IOException {
        File src = new File("C:\\Users\\Indium Software\\IdeaProjects\\mavencontentGrail\\config\\Configuration.properties");
        FileInputStream fis = new FileInputStream(src);
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.setProperty("webdriver.chrome.driver", prop.getProperty("path"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        loginLocators lo = new loginLocators(driver);
        lo.getSignIn().click();
        lo.getEmail().sendKeys(username);
        lo.getPassword().sendKeys(password);
        lo.getPassword().sendKeys(Keys.ENTER);

    }

    @Test
    public void singleTypeQuestions() throws IOException, InterruptedException {
        login();
        resource re = new resource();
        Thread.sleep(3000);
        booksLocators books = new booksLocators(driver);
        WebElement element = driver.findElement(By.cssSelector("[href='/books']"));
        re.scrollIntoView(driver, element);
        Thread.sleep(3000);
        books.clickOnBooks().click();
        List<String> grade = Arrays.asList("Grade 12, Grade 11, Grade 8, Grade 7, Grade 6");
        List<String> syllabus = Arrays.asList("ICSE", "CBSE", "IB", "NGSS", "Banking", "Railway");
        List<String> language = Arrays.asList("English", "Hindi", "Tamil", "Telugu", "French", "Kannada");
        List<String> subject = Arrays.asList("Physics", "Chemistry", "Biology", "Mathematics");
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
            int publist = rand.nextInt(pub.size());
            String publications = pub.get(publist);
            String num = RandomStringUtils.random(1, "9");
//           books.clickOnPublications().sendKeys(publications);
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
            driver.navigate().to("https://new-content-admin-staging.embibe.com");
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
    //String name = "Automation Book 1 - ";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//questions creation begins from here
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getSingleChoice().click();
        resource rep = new resource();
        rep.scrollDown(driver,300);
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Question");
        driver.switchTo().defaultContent();
        rep.scrollDown(driver,250);
        questionsLocators.getoption1().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 1");
        driver.switchTo().defaultContent();
        questionsLocators.getSlider().click();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        rep.scrollDown(driver,350);
        questionsLocators.getoption2().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 2");
        driver.switchTo().defaultContent();
        rep.scrollDown(driver,300);
        questionsLocators.getoption3().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 3");
        driver.switchTo().defaultContent();
        rep.scrollDown(driver,300);
        questionsLocators.getoption4().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 4");
        driver.switchTo().defaultContent();
        rep.scrollDown(driver,250);
        questionsLocators.getbookDropdown().click();
        questionsLocators.getbook().click();
        rep.scrollDown(driver,-250);
        questionsLocators.getSelection().click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]")).click();
        rep.scrollDown(driver,250);
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        rep.scrollDown(driver,250);
        questionsLocators.getsmartTag().click();
        questionsLocators.getjeeMain().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }}

    @Test
    public void multipleTypeQuestions() throws IOException, InterruptedException {
        resource re = new resource();
        re.scrollDown(driver,250);
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getmultipleChoice().click();
        re.scrollDown(driver,250);
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Multiple Type Question");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,250);
        questionsLocators.getoption1().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 1");
        driver.switchTo().defaultContent();
        questionsLocators.getSlider().click();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        questionsLocators.getoption2().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 2");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,250);
        questionsLocators.getoption3().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 3");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,250);
        questionsLocators.getoption4().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 4");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,250);
        questionsLocators.getbookDropdown().click();
        questionsLocators.getgrade().click();
        re.scrollDown(driver,- 250);
        questionsLocators.getSelection().click();
        questionsLocators.getGrade5().click();
        questionsLocators.getaddTag().click();
        re.scrollDown(driver,250);
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,250);
        questionsLocators.getsmartTag().click();
        questionsLocators.getjeeMain().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }

    @Test
    public void integerTypeQuestion() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        resource re = new resource();
        re.scrollDown(driver,250);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getintegerType().click();
        re.scrollDown(driver,250);
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("IntegerType Question");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,250);
        questionsLocators.getintergerOption().click();
        questionsLocators.getintergerOption().sendKeys("Option 1");
        driver.switchTo().defaultContent();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        re.scrollDown(driver,250);
        questionsLocators.getbookDropdown().click();
        questionsLocators.getgrade().click();
        re.scrollDown(driver,- 250);
        questionsLocators.getSelection().click();
        questionsLocators.getGrade5().click();
        questionsLocators.getaddTag().click();
        re.scrollDown(driver,250);
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        re.scrollDown(driver,350);
        questionsLocators.getsmartTag().click();
        questionsLocators.getNEET().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        re.scrollDown(driver,850);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps" +
                "-main')]//div[@class='topic-filters" + "']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Railway')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']" +
                "//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Railway RRB')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']//div//d" +
                "iv[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='General Science']")).click();

        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }

    @Test
    public void trueOrFalseTypeQuestion() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.gettrueOrFalseType().click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("True or False Type Question");
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getSlider().click();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getbookDropdown().click();
        questionsLocators.getsyllabus().click();
        js.executeScript("window.scrollBy(0,-250)");
        questionsLocators.getSelection().click();
        questionsLocators.getICSE().click();
        questionsLocators.getaddTag().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        js.executeScript("window.scrollBy(0,350)");
        questionsLocators.getsmartTag().click();
        questionsLocators.getjeeMain().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps" +
                "-main')]//div[@class='topic-filters" + "']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Banking')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']" +
                "//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'SBI PO Mains')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']//div//d" +
                "iv[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='General Awareness']")).click();

        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }

    @Test
    public void subjectiveNumericalTypeQuestion() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getsubjectiveNumericalType().click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Subjective Numerical Type Question");
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getintergerOption().click();
        questionsLocators.getintergerOption().sendKeys("Option 1");
        driver.switchTo().defaultContent();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getbookDropdown().click();
        questionsLocators.getbook().click();
        js.executeScript("window.scrollBy(0,-250)");
        questionsLocators.getSelection().click();
        questionsLocators.gettestBook().click();
        questionsLocators.getaddTag().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        js.executeScript("window.scrollBy(0,350)");
        questionsLocators.getsmartTag().click();
        questionsLocators.getNEET().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps" +
                "-main')]//div[@class='topic-filters" + "']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'9th')]]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']" +
                "//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'9th Foundation')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']//div//d" +
                "iv[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='Science']")).click();
        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }

    @Test
    public void assertionTypeQuestion() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getassertionOption().click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Assertion Type Question");
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getSlider().click();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        js.executeScript("window.scrollBy(0,750)");
        questionsLocators.getbookDropdown().click();
        Thread.sleep(3000);
        questionsLocators.getAuthor().click();
        Thread.sleep(3000);
        questionsLocators.getSelection().click();
        Thread.sleep(3000);
        questionsLocators.getTester().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getaddTag().click();
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        js.executeScript("window.scrollBy(0,350)");
        questionsLocators.getsmartTag().click();
        questionsLocators.getNEET().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps" +
                "-main')]//div[@class='topic-filters" + "']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//div[text()='10th Foundation']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']" +
                "//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='10th NTSE']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']//div//d" +
                "iv[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='Science']")).click();
        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }

    @Test
    public void subjectiveTypeQuestion() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getsubjective().click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Subjective Type Question");
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//div[@class='general-type-solution']//div[contains(@class,'editor-label')]")).click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getbookDropdown().click();
        questionsLocators.getbook().click();
        js.executeScript("window.scrollBy(0,-250)");
        questionsLocators.getSelection().click();
        questionsLocators.gettestBook().click();
        questionsLocators.getaddTag().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        js.executeScript("window.scrollBy(0,350)");
        questionsLocators.getsmartTag().click();
        questionsLocators.getjeeMain().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps" +
                "-main')]//div[@class='topic-filters" + "']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='Medical']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']" +
                "//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='NEET']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']//div//d" +
                "iv[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='Physics']")).click();
        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }

    @Test
    public void subjectiveAnswerTypeQuestion() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\Indium Software\\Documents\\questions.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String row = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println(row);
        login();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        questionsLocators questionsLocators = new questionsLocators(driver);
        questionsLocators.getQuestions().click();
        questionsLocators.getCreateNewQuestions().click();
        questionsLocators.getType().click();
        Thread.sleep(3000);
        questionsLocators.getsubjectiveAnswerType().click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println(numberOfTags);
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Subjective Answer Type Question");
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getoption1().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Option 1");
        driver.switchTo().defaultContent();
        questionsLocators.getsolutionStep().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Sample");
        driver.switchTo().defaultContent();
        questionsLocators.getblockQuote().click();
        questionsLocators.getcreateStep().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.getbookDropdown().click();
        questionsLocators.getbook().click();
        js.executeScript("window.scrollBy(0,-250)");
        questionsLocators.getSelection().click();
        questionsLocators.gettestBook().click();
        questionsLocators.getaddTag().click();
        js.executeScript("window.scrollBy(0,250)");
        questionsLocators.gethint().click();
        questionsLocators.getHintEditor().click();
        driver.switchTo().frame(0);
        questionsLocators.getQuestionEditorSection().sendKeys("Hint 1");
        driver.switchTo().defaultContent();
        js.executeScript("window.scrollBy(0,350)");
        questionsLocators.getsmartTag().click();
        questionsLocators.getNEET().click();
        Thread.sleep(3000);
        questionsLocators.getsmartTagButton().click();
        js.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps" +
              "-main')]//div[@class='topic-filters" + "']//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='Engineering']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']" +
                "//div//div[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='JEE Main']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='meta-learning-container']//div[contains(@class,'question-learning-maps-main')]//div[@class='topic-filters']//div//d" +
                "iv[contains(@class,'css-2b097c-container')]//div[@class='css-bph5ye']")).click();
        driver.findElement(By.xpath("//*[text()='Physics']")).click();
//        driver.findElement(By.xpath("//div[@class='MuiInputBase-root-876 MuiOutlinedInput-root-860 t-inputRoot-829 MuiInputBase-formControl-877 MuiInputBase-adornedEnd-881 MuiOutl" +
//                "inedInput-adornedEnd-865']//input[@id='downshift-simple-input']")).sendKeys("potential");
//
//        driver.findElement(By.id("topic-checkbox-0")).click();
//        driver.findElement(By.id("topic-checkbox-1")).click();
//        driver.findElement(By.id("topic-checkbox-2 ")).click();

        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,750)");
        questionsLocators.getstatusDropdown().click();
        questionsLocators.getpendingApproval().click();
        Thread.sleep(2000);
        questionsLocators.getsubmitButton().click();
    }
}
