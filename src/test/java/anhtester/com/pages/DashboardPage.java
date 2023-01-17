package anhtester.com.pages;

import org.openqa.selenium.By;

public class DashboardPage extends CommonPage {

    public DashboardPage() {
    }

    private By labelTotalProjects = By.xpath("//h6[normalize-space()='Total Projects']");

}
