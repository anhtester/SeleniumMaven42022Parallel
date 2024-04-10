package anhtester.com.testcases;

import anhtester.com.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LearnTestListener {

    WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
    }

    @Test(priority = 1) //Success Test
    public void gotoPage() {
        driver.get("https://anhtester.com");
    }

    @Test(priority = 2) //Failed Test
    public void checkTitle() {
        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Title of the website do not match");
    }

    @Test(priority = 4) //Failed Test
    public void checkURL() {
        String expectedTitle = "https://anhtester";
        String originalTitle = driver.getCurrentUrl();
        Assert.assertEquals(originalTitle, expectedTitle, "URL of the website do not match");
    }

    @Test(priority = 3)  //Skip Test
    public void skipTest() {
        throw new SkipException("Skipping The Test Method ");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}
