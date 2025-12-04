package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.prestashop.com/#/en/front");

        // Aguarda o iframe da loja carregar
        Thread.sleep(6000);
        driver.switchTo().frame("framelive");
    }

    @Test
    public void testScrollUpAndDown() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll até o final da página
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        // Verifica se o footer está presente após rolar
        WebElement footer = driver.findElement(By.id("footer"));
        Assertions.assertTrue(footer.isDisplayed());

        // Scroll para o topo
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);

        // Verifica se o header está visível novamente
        WebElement header = driver.findElement(By.id("header"));
        Assertions.assertTrue(header.isDisplayed());
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
