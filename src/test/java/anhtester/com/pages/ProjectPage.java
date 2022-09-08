package anhtester.com.pages;

import anhtester.com.driver.DriverManager;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ProjectPage extends CommonPage {

    public ProjectPage() {
    }

    public String pageText = "Dự án";
    public By headerPage = By.xpath("//li[@class='nav-item active']//a[contains(@href, '/erp/projects-list')]");
    By buttonThemMoi = By.xpath("//a[normalize-space()='Thêm mới']");
    By inputTieuDe = By.xpath("//input[@placeholder='Tiêu đề']");
    By dropdownKhachHang = By.xpath("//span[@id='select2-client_id-container']");
    By inputKhachHang = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");

    By inputNote = By.id("summary");

    By buttonLuu = By.xpath("//span[contains(text(),'Lưu')]");


    public void clickButtonThemMoi() {
        WebUI.clickElement(buttonThemMoi);
    }

    public void enterData(String projectName) {
        WebUI.setText(inputTieuDe, projectName);
        WebUI.clickElement(dropdownKhachHang);
        WebUI.setText(inputKhachHang, "Huong Nguyen");
        DriverManager.getDriver().findElement(inputKhachHang).sendKeys(Keys.ENTER);

        WebUI.sleep(1);

        DriverManager.getDriver().findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();

        DriverManager.getDriver().findElement(By.xpath("//a[normalize-space()='21']")).click();

        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        WebUI.sleep(1);

        DriverManager.getDriver().findElement(By.xpath("//label[contains(text(),'Ngày kết thúc')]/following-sibling::div")).click();

        DriverManager.getDriver().findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();

        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();

        WebUI.setText(inputNote, "Note");

    }

    public void addProject(String projectName) {
        clickButtonThemMoi();
        enterData(projectName);
    }

}
