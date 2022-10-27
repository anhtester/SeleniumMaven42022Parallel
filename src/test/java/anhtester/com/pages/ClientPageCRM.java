package anhtester.com.pages;

import anhtester.com.driver.DriverManager;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ClientPageCRM {
    By buttonSignIn = By.xpath("//button[normalize-space()='Sign in']");
    By menuClients = By.xpath("//span[normalize-space()='Clients']");
    By tabClients = By.xpath("//a[contains(text(),'Clients')]");
    By dropdownClientGroups = By.xpath("(//span[normalize-space()='- Client groups -'])[1]");
    By inputClientGroups = By.xpath("//div[@id='select2-drop']//input");
    By totalItemOnOnePage = By.xpath("//div[@id='client-table_length']//a");
    By itemAll = By.xpath("//div[@id='select2-drop']//ul//li[normalize-space()='All']");

    public void signIn(){
        WebUI.openURL("https://rise.fairsketch.com");
        WebUI.clickElement(buttonSignIn);
    }

    public void openClientPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuClients);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(tabClients);
    }

    public void selectClientGroup(String clientGroup){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(totalItemOnOnePage);
        WebUI.clickElement(itemAll);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(dropdownClientGroups);
        WebUI.setText(inputClientGroups, clientGroup);
        WebUI.pressENTER();
    }

    public void checkSearchTableByColumn(int column, String value) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        //Xác định số dòng của table sau khi search
        List<WebElement> row = WebUI.getWebElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);
        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = WebUI.getWebElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]//li"));

            WebUI.scrollToElement(elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertEquals(elementCheck.getText(), value, "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }

}
