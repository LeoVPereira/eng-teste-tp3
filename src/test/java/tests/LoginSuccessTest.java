package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoggedInPage;

public class LoginSuccessTest extends BaseTest {

    @Test
    public void testLoginSuccess() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage login = new LoginPage(driver);
        login.login("student", "Password123");

        LoggedInPage loggedPage = new LoggedInPage(driver);

        Assert.assertTrue(loggedPage.isLoggedIn(), "Login não foi realizado com sucesso");

        // Validação pela URL
        Assert.assertTrue(driver.getCurrentUrl().contains("logged-in-successfully"));
    }
}
