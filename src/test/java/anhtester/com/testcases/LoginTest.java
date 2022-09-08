package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.helpers.PropertiesHelper;
import anhtester.com.pages.CommonPage;
import anhtester.com.pages.LoginPage;
import anhtester.com.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest() {
        //Truyền driver từ BaseTestOLD sang các class Page
        loginPage = new LoginPage();
        commonPage = new CommonPage();
//        PropertiesHelper.setValue("username", "leader01");
//        PropertiesHelper.setValue("password", "123456");
//        PropertiesHelper.setValue("pin", "123");

        PropertiesHelper.setValue("username", "employee01");

        //Đọc 1 file
        PropertiesHelper.setFile("src/test/resources/data.properties");
    }

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage.logIn(PropertiesHelper.getValue("username"), PropertiesHelper.getValue("password"));
        commonPage.dangXuat();
        WebUI.sleep(2);
    }

    @Test(priority = 2)
    public void testLoginWithUsernameInValid() {
        loginPage.loginWithUsernameInValid("admin0123", "123456");

    }

    @Test(priority = 3)
    public void testLoginWithPasswordInValid() {
        loginPage.loginWithPasswordInValid("admin01", "123456789");
    }

    @Test(priority = 4)
    public void testForgotPassword() {
        loginPage.resetPassword("client01@mailinator.com");

    }

    @Test(priority = 5)
    public void testReadProperties() {
        System.out.println(PropertiesHelper.getValue("category"));
        System.out.println(PropertiesHelper.getValue("product"));

        System.out.println(PropertiesHelper.getValue("username"));
    }

}
