package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.DashboardPage;
import anhtester.com.pages.LoginPage;
import anhtester.com.pages.ProjectPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;

    @BeforeMethod
    public void setupTest() {
        //Lúc nào nó cũng sẽ khởi tạo trước
        //Vì nó là hành động đầu tiên
        loginPage = new LoginPage();
    }

    @Test
    public void testOpenProject() {
        //Login
        //Nhấn menu Project tại trang Dashboard

        //Tạo sự liên kết trang thông qua gán dấu = từ đối tượng trang = hàm đã liên kết
        //Không cần khởi tạo trang từ đầu ( dashboardPage = new DashboardPage(driver); )
        //DashboardPage sẽ được khởi tạo luôn khi Login thành công
        //dashboardPage = new DashboardPage(driver);
        dashboardPage = loginPage.logIn("admin01", "123456"); //dashboardPage = new DashboardPage(driver);
        dashboardPage.openProject();

    }

    @Test
    public void testAddProject() {
        dashboardPage = loginPage.logIn("admin01", "123456");
        projectPage = dashboardPage.openProject();
        projectPage.addProject("PD0609A1");
    }

    @Test
    public void testNavigateToTasks() {
        dashboardPage = loginPage.logIn("leader01", "123456");
        projectPage = dashboardPage.openProject();
        projectPage.openTask();

    }

}
