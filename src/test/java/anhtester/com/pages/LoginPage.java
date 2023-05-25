package anhtester.com.pages;

import anhtester.com.constants.ConstantGlobal;
import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends CommonPage {

    //Hàm xây dựng
    public LoginPage() {
    }

    //Login
    private String pageText = "Welcome to HRSALE";
    private By inputUsername = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By buttonSignin = By.xpath("//button[@type='submit']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");

    //Forgot password
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.xpath("//button[@type='submit']");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");
    private By alertMessage = By.xpath("//div[@class='toast-message']");

    public void loginNormal(String username, String password) {
        WebUI.openURL(ConstantGlobal.URL);
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSignin);
    }

    public DashboardPage logIn(String username, String password) {
        loginNormal(username, password);
        WebUI.waitForPageLoaded();
        boolean checkMenu = WebUI.checkElementExist(menuTrangChu);
        Assert.assertTrue(checkMenu, "Login failed. Can not navigate to Dashboard page.");

        return new DashboardPage(); //Khởi tạo trang Dashboard
    }

    public void loginWithUsernameInValid(String username, String password) {
        loginNormal(username, password);
        //Assert kiểm tra chuyển hướng trang
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error alert not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Invalid Login Credentials.");
    }

    public void loginWithPasswordInValid(String username, String password) {
        loginNormal(username, password);
        //Assert kiểm tra alert message
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error alert not display.");
        //Invalid Login Credentials.
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Invalid Login Credentials.");

    }

    public void resetPassword(String emailForgot) {
        WebUI.openURL(ConstantGlobal.URL);
        WebUI.clickElement(linkForgotPassword);
        WebUI.verifyEquals(WebUI.getElementText(pageTextForgotPassword), "Reset your password");
        WebUI.setText(inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);
        //Assert cái message hiển thị thành công (tồn tại)
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Main.xin_error_msg_not");
        WebUI.clickElement(linkClickHere);
    }

}
