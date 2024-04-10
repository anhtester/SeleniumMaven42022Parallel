package anhtester.com.LearnParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ChromeTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.out.println("Initilizing the Google Chrome Driver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void ChromeTestMethod1() {
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
    }

    @Test
    public void ChromeTestMethod2() {
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("Quit the browser ");
        driver.quit();
    }
}
