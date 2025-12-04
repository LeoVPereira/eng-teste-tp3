package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By checkoutHeader = By.cssSelector("h1.h1");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCheckoutPage() {
        return driver.findElement(checkoutHeader).getText().contains("Checkout");
    }
}
