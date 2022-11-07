package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.dataprovider.DataProviderManager;
import anhtester.com.helpers.ExcelHelpers;
import anhtester.com.pages.CommonPage;
import anhtester.com.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test")
@Epic("Regression Test v1.0.0")
@Feature("Login Test")
public class LoginTest extends BaseTest {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
    }

    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void testLoginFromDataProvider(String username, String password) {
        loginPage.logIn(username, password);
        commonPage.dangXuat();
    }

    @Test(priority = 2, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
    public void testLoginDataProviderFromExcelByRow(Hashtable<String, String> data) {
        loginPage.logIn(data.get("username"), data.get("password"));
        //commonPage.dangXuat();
    }

    @Test(priority = 3)
    public void testLoginSuccessEXCEL() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1"); //Khai báo file và sheet
        loginPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));

    }

    @Test(priority = 4)
    public void testLoginWithUsernameInValid() {
        loginPage.loginWithUsernameInValid("admin012356", "frances.burns");

    }

    @Test(priority = 5)
    public void testLoginWithPasswordInValid() {
        loginPage.loginWithPasswordInValid("frances.burns", "123456789");

    }

    @Test(priority = 6)
    public void testForgotPassword() {
        loginPage.resetPassword("client01@mailinator.com");

    }

}
