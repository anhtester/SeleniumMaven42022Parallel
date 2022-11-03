package anhtester.com.common;

import anhtester.com.driver.DriverManager;
import anhtester.com.helpers.PropertiesHelpers;
import anhtester.com.listeners.TestListener;
import anhtester.com.pages.CommonPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners(TestListener.class)
public class BaseTest extends CommonPage {

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browserName) {
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
        //PropertiesHelpers.loadAllFiles();
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult result) {
        //Chụp màn hình khi Fail
        if (result.getStatus() == ITestResult.FAILURE) {

            // Tạo tham chiếu của TakesScreenshot với driver hiện tại
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
// Gọi hàm capture screenshot - getScreenshotAs
            File source = ts.getScreenshotAs(OutputType.FILE);
//Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
            File theDir = new File("./Screenshots/");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
// result.getName() lấy tên của test case xong gán cho tên File chụp màn hình luôn
            try {
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot taken: " + result.getName());

        }


        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
