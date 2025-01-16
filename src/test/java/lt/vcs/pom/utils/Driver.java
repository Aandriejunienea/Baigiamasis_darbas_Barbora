package lt.vcs.pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static WebDriver driver;

    public static void initChromeDriver() {
        WebDriverManager.chromiumdriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--force-device-scale-factor=0.70");
        options.addArguments("--incognito");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
