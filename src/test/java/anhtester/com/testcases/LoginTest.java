package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.helpers.PropertiesHelper;
import anhtester.com.pages.CommonPage;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
    }

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage.logIn(PropertiesHelper.getValue("username"), PropertiesHelper.getValue("password"));
        commonPage.dangXuat();
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

}
