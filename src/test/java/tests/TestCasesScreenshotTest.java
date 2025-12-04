package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.TestCasesPage;
import utils.ScreenshotUtil;

public class TestCasesScreenshotTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCaptureScreenshots() {
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        // Navega até a página
        testCasesPage.open();

        // Screenshot da página inteira
        ScreenshotUtil.takePageScreenshot(driver, "testcases-full-page");

        // Screenshot de um elemento específico (título)
        ScreenshotUtil.takeElementScreenshot(
                testCasesPage.getTitleElement(),
                "testcases-title"
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
