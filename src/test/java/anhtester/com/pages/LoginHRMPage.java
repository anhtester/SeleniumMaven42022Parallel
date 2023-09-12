package anhtester.com.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;

public class LoginHRMPage extends CommonPage {

    //Ghi các object của page này ra
    By buttonSuperAdmin = By.xpath("//button[normalize-space()='Super Admin']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='iusername']");
    By inputPassword = By.xpath("//input[@id='ipassword']");

    public void login() {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputEmail, "admin_example");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }
}
