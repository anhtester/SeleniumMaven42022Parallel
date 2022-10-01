package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.dataprovider.DataProviderManager;
import anhtester.com.helpers.ExcelHelpers;
import anhtester.com.pages.CommonPage;
import anhtester.com.pages.LoginPage;
import anhtester.com.utils.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

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
        Log.info(username + " - " + password);

        //commonPage.dangXuat();
    }

//    @Test(priority = 1, dataProvider = "data_provider_login_from_excel", dataProviderClass = DataProviderManager.class)
//    public void testLoginDataProviderFromExcel(String username, String password, String result) {
//        loginPage.logIn(username, password);
//        commonPage.dangXuat();
//    }

    @Test(priority = 1, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
    public void testLoginDataProviderFromExcelByRow(Hashtable<String, String> data) {
        loginPage.logIn(data.get("username"), data.get("password"));
        //commonPage.dangXuat();
    }

//    @Test(priority = 1)
//    public void testLoginSuccess() {
//        loginPage.logIn(PropertiesHelpers.getValue("username"), PropertiesHelpers.getValue("password"));
//        commonPage.dangXuat();
//    }

    @Test(priority = 2)
    public void testLoginSuccessEXCEL() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1"); //Khai báo file và sheet
        loginPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));

    }

    @Test(priority = 3)
    public void testGetAllDataEXCEL() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1"); //Khai báo file và sheet

        System.out.println(excelHelpers.getLastRowNum());
        System.out.println(excelHelpers.getPhysicalNumberOfRows());

        for (int i = 1; i <= excelHelpers.getLastRowNum(); i++) {
            System.out.println(excelHelpers.getCellData("username", i));
            System.out.println(excelHelpers.getCellData("password", i));
            System.out.println(excelHelpers.getCellData("result", i));
        }

        excelHelpers.setCellData("passed", 2, "result");
        excelHelpers.setCellData("success", 3, "result");
        excelHelpers.setCellData("failed", 4, "result");

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
