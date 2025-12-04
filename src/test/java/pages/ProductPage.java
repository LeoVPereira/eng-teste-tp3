package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    private By addToCartBtn = By.cssSelector("button.add-to-cart");
    private By reviewTab = By.id("reviews-tab");
    private By reviewInput = By.id("comment_title");
    private By reviewContent = By.id("content");
    private By sendReviewBtn = By.id("submitNewMessage");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void addReview(String title, String description) {
        driver.findElement(reviewTab).click();
        driver.findElement(reviewInput).sendKeys(title);
        driver.findElement(reviewContent).sendKeys(description);
        driver.findElement(sendReviewBtn).click();
    }
}
