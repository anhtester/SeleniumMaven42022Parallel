package anhtester.com.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CommonPage {

    public CommonPage() {

    }

    //Khai báo đối tượng cho Class chung
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ProjectPage projectPage;
    public TaskPage taskPage;
    public LoginHRMPage loginHRMPage;

    //Object chung
    public By headerPage = By.xpath("//li[@class='nav-item active']/a");
    public By buttonDangXuat = By.xpath("//div[@class='page-header']//a[normalize-space()='Logout']");
    private By menuProject = By.xpath("//span[contains(text(),'Projects')]");
    private By menuTask = By.xpath("//span[normalize-space()='Tasks']");
    //Hàm chung để get khởi tạo của các trang khai báo trên và các hàm xử lý chung


    public LoginPage dangXuat() {
        WebUI.clickElement(buttonDangXuat);

        return new LoginPage();
    }

    public ProjectPage openProject() {
        WebUI.clickElement(menuProject);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail. Chưa mở được trang Project. Element not found " + headerPage);
        String checkText = WebUI.getElementText(headerPage);
        Assert.assertTrue(checkText.contains(getProjectPage().pageText), "Fail. Text of Header Project page not match.");
        return new ProjectPage();
    }

    public TaskPage openTask() {
        WebUI.clickElement(menuTask);
        boolean checkPage = WebUI.checkElementExist(headerPage);
        Assert.assertTrue(checkPage, "Fail. Chưa mở được trang Tasks. Element not found " + headerPage);

        String checkText = WebUI.getElementText(headerPage);
        Assert.assertTrue(checkText.contains(getTaskPage().pageText), "Fail. Text of Header Tasks page not match.");
        return new TaskPage();
    }

    //Khởi tạo giá trị cho tất cả các đối tượng class ở trên

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ProjectPage getProjectPage() {
        if (projectPage == null) {
            projectPage = new ProjectPage();
        }
        return projectPage;
    }

    public TaskPage getTaskPage() {
        if (taskPage == null) {
            taskPage = new TaskPage();
        }
        return taskPage;
    }

    public LoginHRMPage getLoginHRMPage() {
        if (loginHRMPage == null) {
            loginHRMPage = new LoginHRMPage();
        }
        return loginHRMPage;
    }

}
