package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.helpers.SystemHelpers;
import anhtester.com.pages.UploadFileCMSPage;
import anhtester.com.keywords.WebUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("Regression Test")
@Feature("Upload Test")
public class UploadFileCMS extends BaseTest {

    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {
        WebUI.openURL("https://cgi-lib.berkeley.edu/ex/fup.html");
        WebUI.waitForPageLoaded();
        By inputFileUpload = By.xpath("//input[@name='upfile']");

        //DriverManager.getDriver().findElement(inputFileUpload).sendKeys(SystemHelpers.getCurrentDir() + "datatest/Selenium4_Upload.png");
        WebUI.setText(inputFileUpload, SystemHelpers.getCurrentDir() + "datatest\\Selenium4_Upload.jpg");
        Thread.sleep(3000);
    }

    @Test
    public void testUploadFileInCategoryCMS() {
        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        uploadFileCMSPage.loginCMS();
        uploadFileCMSPage.uploadFileInCategory();
    }

}
