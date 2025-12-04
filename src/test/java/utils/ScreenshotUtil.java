package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static void takePageScreenshot(WebDriver driver, String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        save(src, "screenshots/page-" + name);
    }

    public static void takeElementScreenshot(WebElement element, String name) {
        File src = element.getScreenshotAs(OutputType.FILE);
        save(src, "screenshots/element-" + name);
    }

    private static void save(File src, String fileName) {
        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            File dest = new File(fileName + "-" + timestamp + ".png");
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}
