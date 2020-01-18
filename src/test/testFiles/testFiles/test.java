package testFiles;

import com.github.javafaker.Faker;
import loginModule.loginLocators;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.resource;
import users.userslocators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;
    resource re = new resource();

    @Test
    public void randomNames() throws InterruptedException, IOException {
        Faker faker = new Faker();
        String Firstname = faker.app().name();
        String name = faker.name().firstName();
        String code = faker.number().digits(10);
        String address = faker.address().streetAddress();
        String number = faker.book().publisher();
        System.out.println(number);
    }
}