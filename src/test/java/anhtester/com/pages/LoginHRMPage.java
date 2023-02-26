package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;

public class LoginHRMPage extends CommonPage {

    //Ghi các object của page này ra
    By buttonSuperAdmin = By.xpath("//button[normalize-space()='Super Admin']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    public void login() {
        WebUI.openURL("https://app.hrsale.com/erp/login");
        WebUI.clickElement(buttonSuperAdmin);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }
}
