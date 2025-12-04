package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void testRegisterUser() {
        driver.get("https://demo.prestashop.com/#/en/front");

        HomePage home = new HomePage(driver);
        home.clickSignIn();

        RegisterPage register = new RegisterPage(driver);
        register.createUser("Leonardo", "Pereira", "Senha123");
    }
}
