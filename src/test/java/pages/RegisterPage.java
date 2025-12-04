package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    private By createAccountBtn = By.id("submitCreate");
    private By genderMale = By.id("id_gender1");
    private By firstName = By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By password = By.id("passwd");
    private By registerBtn = By.id("submitAccount");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createUser(String fName, String lName, String pass) {
        driver.findElement(genderMale).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(registerBtn).click();
    }
}
