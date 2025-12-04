package tests;

import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileWriter;
import java.io.IOException;

public class LoginAndSaveCookiesTest extends BaseTest {

    @Test
    public void testLoginAndSaveCookies() throws IOException {

        driver.get("https://demo.prestashop.com/#/en/front");

        // Abre a página de login
        driver.get("https://demo.prestashop.com/#/en/login");

        LoginPage login = new LoginPage(driver);
        login.login("seuemail@teste.com", "SuaSenha123");

        // SALVAR COOKIES EM ARQUIVO
        FileWriter writer = new FileWriter("cookies.data");

        for (Cookie cookie : driver.manage().getCookies()) {
            writer.write(
                    cookie.getName() + ";" +
                            cookie.getValue() + ";" +
                            cookie.getDomain() + ";" +
                            cookie.getPath() + ";" +
                            cookie.getExpiry() + ";" +
                            cookie.isSecure() + "\n"
            );
        }

        writer.close();
    }
}
