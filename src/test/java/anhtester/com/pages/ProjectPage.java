package anhtester.com.pages;

import anhtester.com.driver.DriverManager;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ProjectPage extends CommonPage {

    public ProjectPage() {
    }

    public String pageText = "Projects";
    public By headerPage = By.xpath("//li[@class='nav-item active']//a[contains(@href, '/erp/projects-list')]");
    By buttonAddNew = By.xpath("//a[normalize-space()='Add New']");
    By inputTitle = By.xpath("//input[@placeholder='Title']");
    By dropdownClient = By.xpath("//span[@id='select2-client_id-container']");
    By inputClient = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");
    By inputStartDate = By.xpath("//label[contains(text(),'Start Date')]/following-sibling::div");
    By inputNote = By.id("summary");
    By dropdownTeam = By.xpath("//ul[@class='select2-selection__rendered']");
    By inputTeam = By.xpath("//ul[@class='select2-selection__rendered']//input");
    By buttonSave = By.xpath("//span[contains(text(),'Save')]");
    By buttonListView = By.xpath("//a[@data-original-title='List View']");
    By inputSearch = By.xpath("//input[@aria-controls='xin_table']");
    By labelProjectNameOnTable = By.xpath("//table[@id='xin_table']//tbody//tr[1]//td[1]");

    public void clickButtonThemMoi() {
        WebUI.clickElement(buttonAddNew);
    }

    public void enterData(String projectName) {
        WebUI.setText(inputTitle, projectName);
        WebUI.clickElement(dropdownClient);
        WebUI.setText(inputClient, "Client Example");
        DriverManager.getDriver().findElement(inputClient).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        DriverManager.getDriver().findElement(By.xpath("//label[contains(text(),'Start Date')]/following-sibling::div")).click();
        DriverManager.getDriver().findElement(By.xpath("//a[normalize-space()='21']")).click();
        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
        WebUI.sleep(1);
        DriverManager.getDriver().findElement(By.xpath("//label[contains(text(),'End Date')]/following-sibling::div")).click();
        DriverManager.getDriver().findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();
        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();
        WebUI.setText(inputNote, "Note");
        WebUI.scrollToElement(inputStartDate);
        WebUI.clickElement(dropdownTeam);
        WebUI.clickElement(By.xpath("//li[contains(.,'Project Manager')]"));
        WebUI.clickElement(buttonSave);
    }

    public void checkDataAddProject(String projectName) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        WebUI.setText(inputSearch, projectName);
        WebUI.waitForPageLoaded();
        WebUI.verifyEquals(WebUI.getElementText(labelProjectNameOnTable), projectName);
    }

    public void addProject(String projectName) {
        clickButtonThemMoi();
        enterData(projectName);
        checkDataAddProject(projectName);
    }

}
