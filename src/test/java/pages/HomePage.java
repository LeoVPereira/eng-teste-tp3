package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By signInBtn = By.cssSelector("a.user-info");
    private By firstProduct = By.cssSelector(".product-thumbnail");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInBtn).click();
    }

    public void openFirstProduct() {
        driver.findElements(firstProduct).get(0).click();
    }
}
