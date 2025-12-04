package tests;

import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReuseCookiesTest extends BaseTest {

    @Test
    public void testReuseCookies() throws Exception {

        driver.get("https://demo.prestashop.com/#/en/front");

        // CARREGA E APLICA COOKIES
        BufferedReader reader = new BufferedReader(new FileReader("cookies.data"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            Cookie cookie = new Cookie(parts[0], parts[1], parts[2], parts[3], null);
            driver.manage().addCookie(cookie);
        }

        reader.close();

        // Recarrega a página após aplicar os cookies
        driver.navigate().refresh();

        // Acessar página de checkout sem realizar login
        driver.get("https://demo.prestashop.com/#/en/order");

        CheckoutPage checkout = new CheckoutPage(driver);
        Assert.assertTrue(checkout.isCheckoutPage(), "Usuário não está logado pela sessão persistida");
    }
}