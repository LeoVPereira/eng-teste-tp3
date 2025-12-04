package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.CartPage;

public class AddToCartTest2 {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.prestashop.com/#/en/front");

        // Aguarda o iframe da loja carregar
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ignored) { }

        driver.switchTo().frame("framelive");
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        // Abre o primeiro produto
        home.openFirstProduct();

        // Adiciona ao carrinho
        product.addToCart();

        // Aguarda modal aparecer
        Thread.sleep(3000);

        // Clica no botão "Proceed to checkout" que aparece no modal
        WebElement proceedBtn = driver.findElement(By.cssSelector(".cart-content-btn a"));
        proceedBtn.click();

        // Validação básica: existe um botão de continuar o checkout?
        Assertions.assertTrue(
                cart.isCheckoutVisible(),
                "O produto não foi adicionado ao carrinho corretamente!"
        );
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
