package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    private WebDriver driver;

    private By subjectDropdown = By.id("id_contact");
    private By emailInput = By.id("email");
    private By messageInput = By.id("message");
    private By sendBtn = By.id("submitMessage");
    private By successAlert = By.cssSelector(".alert-success");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSubject(String subject) {
        Select select = new Select(driver.findElement(subjectDropdown));
        select.selectByVisibleText(subject);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickSend() {
        driver.findElement(sendBtn).click();
    }

    public boolean isMessageSent() {
        return driver.findElement(successAlert).isDisplayed();
    }
}
