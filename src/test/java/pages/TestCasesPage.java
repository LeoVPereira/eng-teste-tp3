package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage {

    private WebDriver driver;

    private By titlePage = By.cssSelector("h2.title.text-center");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://automationexercise.com/test_cases");
    }

    public WebElement getTitleElement() {
        return driver.findElement(titlePage);
    }
}
