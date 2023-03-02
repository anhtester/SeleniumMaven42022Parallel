package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.helpers.ExcelHelpers;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    private ExcelHelpers excelHelpers;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1");
    }

    @Test
    public void testOpenProject() {
        dashboardPage = loginPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));
        dashboardPage.openProject();
    }

    @Test
    public void testAddProject() {
        dashboardPage = loginPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));
        projectPage = dashboardPage.openProject();
        projectPage.addProject("PD0303A1");
    }

    @Test
    public void testNavigateToTasks() {
        dashboardPage = loginPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));
        projectPage = dashboardPage.openProject();
        projectPage.openTask();
    }

}
