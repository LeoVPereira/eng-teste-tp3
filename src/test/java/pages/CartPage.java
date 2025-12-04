package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By proceedToCheckoutBtn = By.cssSelector("a.btn-primary");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCheckoutVisible() {
        return driver.findElement(proceedToCheckoutBtn).isDisplayed();
    }
}
