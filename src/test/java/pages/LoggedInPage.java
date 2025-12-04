package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {

    private WebDriver driver;

    private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
    private By successMessage = By.className("post-title");

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoggedIn() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}
