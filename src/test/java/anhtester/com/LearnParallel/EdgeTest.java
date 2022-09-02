package anhtester.com.LearnParallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class EdgeTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.out.println("Initilizing the Microsoft Edge driver");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void EdgeTestMethod1() {
        //Initialize the Edge driver
        System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='API Testing']")).click();
    }

    @Test
    public void EdgeTestMethod2() {
        //Initialize the Edge driver
        System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='API Testing']")).click();
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("Quit the browser ");
        driver.quit();
    }

}
