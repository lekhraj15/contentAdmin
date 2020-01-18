package resources;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;


public class resource {
  WebDriver driver;

    public void scrollDown(WebDriver driver,int x)
    {

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy('x','"+x+"')");
    }

    public void scrollUp(int x)
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-x)");
    }

    public void screenShot(String result) throws IOException {
     File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("C:\\Users\\Indium Software\\IdeaProjects\\mavencontentGrail\\src\\main\\"+result+"failedpic.png"));

    }

    public void explicitWait(WebDriver driver,WebElement locators, int Timeout)
    {
        new WebDriverWait(driver,Timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locators));
        locators.click();
    }

    public void scrollIntoView(WebDriver driver, WebElement element ) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }




}
